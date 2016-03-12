package com.ai.paas.cpaas.be.am.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetail;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.ResClusterInfo;
import com.ai.paas.cpaas.be.am.manage.model.ActionType;
import com.ai.paas.cpaas.be.am.manage.model.CallBackReq;
import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq;
import com.ai.paas.cpaas.be.am.manage.model.InstanceStateType;
import com.ai.paas.cpaas.be.am.manage.model.TaskIdInfo;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;
import com.ai.paas.cpaas.be.am.manage.model.CallBackReq.Container.Instance;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.marathon.GetAppResp;
import com.ai.paas.cpaas.be.am.manage.model.marathon.GetAppResp.App;
import com.ai.paas.cpaas.be.am.manage.model.marathon.GetAppResp.App.Task;
import com.ai.paas.cpaas.be.am.manage.model.mesos.StateResp;
import com.ai.paas.cpaas.be.am.manage.model.mesos.StateResp.FrameWork;
import com.ai.paas.cpaas.be.am.manage.model.mesos.StateResp.FrameWork.Executor;
import com.ai.paas.cpaas.be.am.service.ConfigMissException;
import com.ai.paas.cpaas.be.am.service.IAppTaskDetailService;
import com.ai.paas.cpaas.be.am.service.IAppTaskLogService;
import com.ai.paas.cpaas.be.am.service.IRemoteService;
import com.ai.paas.cpaas.be.am.service.IResClusterInfoService;
import com.ai.paas.cpaas.be.am.service.ISystemCodesService;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;
import com.ai.paas.cpaas.be.am.service.remote.DirectRemoteService;
import com.ai.paas.cpaas.be.am.util.MgmtConstant;
import com.google.gson.Gson;

/**
 * run marathon requst thread
 * 
 * @author bixy
 *
 * @param <T>
 */
public abstract class RunJobThread<T> implements Runnable {
	private static Logger logger = Logger.getLogger(RunJobThread.class);
	private static final Integer MAX_WAIT = 300;
	protected Map<TaskIdInfo, T> tasks = new HashMap<>();
	protected Map<TaskIdInfo, T> finished = new HashMap<>();
	protected int reqId;
	protected String appId;
	protected ActionType actionType;
	protected GeneralReq generalReq;
	private boolean running = true;

	@Autowired
	protected IResClusterInfoService resClusterInfoService;
	@Autowired
	protected IAppTaskDetailService appTaskDetailService;
	@Autowired
	protected IAppTaskLogService appTaskLogService;
	@Autowired
	protected ISystemCodesService systemCodesService;

	protected IRemoteService remoteService;

	public RunJobThread() {
	}

	@Override
	public void run() {
		try {
			ResClusterInfo resClusterInfo = resClusterInfoService.getClusterInfo(generalReq.getClusterId());
			this.remoteService = new DirectRemoteService(resClusterInfo);
			List<Container> containers = generalReq.getContainers();
			if (CollectionUtils.isNotEmpty(containers)) {
				for (Container container : containers) {
					T t = turnToMarathonReq(container);
					// validate
					if (!validate(container))
						continue;

					// write app_task_log
					int taskId = appTaskDetailService.saveAppTaskDetail(reqId, appId, container.getContainerName(), toJson(t), TaskStateType.STAGING);
					appTaskLogService.saveTaskLog(taskId, "start container " + container.getContainerName(), TaskStateType.STAGING);

					GeneralHttpResp createAppResp = runJob(container.getContainerName(), toJson(t));
					TaskIdInfo taskIdInfo = new TaskIdInfo(taskId, container.getContainerName());
					if (createAppResp.getSuccess()) {
						tasks.put(taskIdInfo, t);
					} else {
						appTaskDetailService.updateAppTaskDetail(taskIdInfo.getTaskId(), TaskStateType.FAIL);
						appTaskLogService.saveTaskLog(taskIdInfo.getTaskId(), createAppResp.getFailedMessage(), TaskStateType.FAIL);
					}
				}
			}
			int i = 0;
			while (running) {
				List<TaskIdInfo> needRemove = new ArrayList<>();
				for (Entry<TaskIdInfo, T> entry : tasks.entrySet()) {
					TaskIdInfo taskIdInfo = entry.getKey();
					GetAppResp getAppResp = remoteService.getContainerInfo(taskIdInfo.getContainerId(), GetAppResp.class);
					if (getAppResp.getSuccess())
						if (getAppResp.getApp().getInstances() == getAppResp.getApp().getTasksRunning()) {
							// running task equals instances , start
							// successful
							appTaskDetailService.updateAppTaskDetail(taskIdInfo.getTaskId(), TaskStateType.SUCCESS);
							appTaskLogService.saveTaskLog(taskIdInfo.getTaskId(), "task success finished", TaskStateType.SUCCESS);
							needRemove.add(taskIdInfo);
						} else {
							continue;
						}
					else {
						// http error ,record message to database without
						// retry
						appTaskDetailService.updateAppTaskDetail(taskIdInfo.getTaskId(), TaskStateType.FAIL);
						appTaskLogService.saveTaskLog(taskIdInfo.getTaskId(), getAppResp.getFailedMessage(), TaskStateType.FAIL);
						needRemove.add(taskIdInfo);
					}
				}
				for (TaskIdInfo taskIdInfo : needRemove) {
					T t = tasks.remove(taskIdInfo);
					finished.put(taskIdInfo, t);
				}
				i++;
				if (MapUtils.isEmpty(tasks)) {
					running = false;
				} else if (i > MAX_WAIT) {
					running = false;
					// over max_wait ,then stop query status
					for (Entry<TaskIdInfo, T> entry : tasks.entrySet()) {
						// update all unfinished task fail
						TaskIdInfo taskIdInfo = entry.getKey();
						appTaskDetailService.updateAppTaskDetail(taskIdInfo.getTaskId(), TaskStateType.FAIL);
						appTaskLogService.saveTaskLog(taskIdInfo.getTaskId(), "task fail because unfinished!", TaskStateType.FAIL);
					}
				} else
					Thread.sleep(1000);
			}
			// task finish , excute call back
			executeCallback();
		} catch (RemoteServiceException e) {
			logger.error(e);
		} catch (InterruptedException e) {
			logger.error(e);
		}
	}

	private void executeCallback() throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost;
			try {
				httpPost = new HttpPost(systemCodesService.getCode(MgmtConstant.CALLBACK, "url"));
			} catch (ConfigMissException e) {
				throw new RuntimeException("callback url isn't set!");
			}

			CallBackReq callBackReq = new CallBackReq();
			callBackReq.setReqId(new Integer(reqId).longValue());
			callBackReq.setAppId(appId);
			callBackReq.setActionType(actionType.getName());
			callBackReq.setClusterId(generalReq.getClusterId());
			callBackReq.setDataCenterId(generalReq.getDataCenterId());
			List<CallBackReq.Container> containers = new ArrayList<>();
			List<AppTaskDetail> appTaskDetails = appTaskDetailService.getTasksByReq(reqId);

			for (AppTaskDetail appTaskDetail : appTaskDetails) {
				CallBackReq.Container container = new CallBackReq.Container();
				container.setContainerName(appTaskDetail.getTaskName());

				GetAppResp getAppResp = remoteService.getContainerInfo(appTaskDetail.getTaskName(), GetAppResp.class);
				if (getAppResp.getSuccess()) {
					App app = getAppResp.getApp();
					container.setInstancesNum(app.getInstances());
					container.setContainerId(appTaskDetail.getTaskName());
					container.setMessage(appTaskDetail.getRespMessage());
					container.setState(TaskStateType.valueOf(appTaskDetail.getTaskState()));
					List<Task> tasks = app.getTasks();
					List<Instance> instances = new ArrayList<>();
					for (Task task : tasks) {
						Instance instance = new Instance();
						instance.setHost(task.getHost());
						if (task.getStartedAt() == null)
							instance.setState(InstanceStateType.FAILED.getName());
						else
							instance.setState(InstanceStateType.RUNNING.getName());
						instance.setInstanceId("mesos-" + task.getSlaveId() + "." + getTaskNameFromMesos(task.getHost(), task.getId()));
						instances.add(instance);
					}
					container.setInstances(instances);
					container.setVersion(app.getVersion());
					containers.add(container);
				} else
					// TODO: fetch task status failed
					continue;
			}
			callBackReq.setContainers(containers);

			StringEntity entity = new StringEntity((new Gson()).toJson(callBackReq), "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);

			httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			throw new RemoteServiceException(e);
		} catch (IOException e) {
			throw new RemoteServiceException(e);
		}
	}

	private String getTaskNameFromMesos(String mesosAddrss, String instanceId) throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://" + mesosAddrss + ":5051/slave(1)/state");
			CloseableHttpResponse resp = httpclient.execute(httpGet);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				StateResp stateResp = (new Gson()).fromJson(respString, StateResp.class);
				for (FrameWork frameWork : stateResp.getFrameworks()) {
					for (Executor executor : frameWork.getExecutors()) {
						if (instanceId.equals(executor.getId()))
							return executor.getContainer();
					}
				}
				return null;
			} else {
				return null;
			}
		} catch (ClientProtocolException e) {
			throw new RemoteServiceException(e);
		} catch (IOException e) {
			throw new RemoteServiceException(e);
		}
	}

	protected abstract T turnToMarathonReq(GeneralReq.Container container);

	protected abstract boolean validate(Container container);

	protected abstract GeneralHttpResp runJob(String containerId, String param) throws RemoteServiceException;

	protected String toJson(Object obj) {
		return (new Gson()).toJson(obj);
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public GeneralReq getGeneralReq() {
		return generalReq;
	}

	public void setGeneralReq(GeneralReq generalReq) {
		this.generalReq = generalReq;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

}
