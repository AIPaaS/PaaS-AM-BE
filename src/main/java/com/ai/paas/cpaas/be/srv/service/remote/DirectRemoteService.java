package com.ai.paas.cpaas.be.srv.service.remote;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.ResClusterInfo;
import com.ai.paas.cpaas.be.srv.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.srv.manage.model.chronos.ChronosJob;
import com.ai.paas.cpaas.be.srv.manage.model.chronos.JobsResp;
import com.ai.paas.cpaas.be.srv.manage.model.consul.ServiceInfo;
import com.ai.paas.cpaas.be.srv.manage.model.marathon.FailedResp;
import com.ai.paas.cpaas.be.srv.service.IRemoteService;
import com.ai.paas.cpaas.be.srv.service.RemoteServiceException;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class DirectRemoteService implements IRemoteService {
	private static Logger logger = Logger.getLogger(DirectRemoteService.class);
	public static final String MARATHON_APP_PATH = "/v2/apps";
	public static final String CONSUL_APP_PATH = "/v1/catalog";
	public static final String CHRONOS_APP_PATH = "/scheduler";
	private ResClusterInfo resClusterInfo;

	public DirectRemoteService(ResClusterInfo resClusterInfo) {
		this.resClusterInfo = resClusterInfo;
	}

	public <T extends GeneralHttpResp> T deployLongRun(String createAppReq, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH);
			StringEntity entity = new StringEntity(createAppReq, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			logger.info(createAppReq);
			CloseableHttpResponse resp = httpclient.execute(httpPost);
			HttpEntity respEntity = resp.getEntity();
			String respString = EntityUtils.toString(respEntity, "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 201) {
				t = (new Gson()).fromJson(respString, cls);
				t.setSuccess(true);
			} else {
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				t = cls.newInstance();
				t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	public <T extends GeneralHttpResp> T getContainerInfo(String containerId, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH + "/" + containerId);
			CloseableHttpResponse resp = httpclient.execute(httpGet);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				t = (new Gson()).fromJson(respString, cls);
				t.setSuccess(true);
			} else {
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				t = cls.newInstance();
				t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	public <T extends GeneralHttpResp> T putConfig(String changeConfigReq, String containerId, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH + "/" + containerId);
			logger.info(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH + "/" + containerId);
			logger.info(changeConfigReq);
			StringEntity entity = new StringEntity(changeConfigReq, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPut.setEntity(entity);
			CloseableHttpResponse resp = httpclient.execute(httpPut);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				t = (new Gson()).fromJson(respString, cls);
				t.setSuccess(true);
			} else {
				logger.info(respString);
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				t = cls.newInstance();
				t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public <T extends GeneralHttpResp> T destroyLongRun(String containerId, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpDelete httpDelete = new HttpDelete(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH + "/" + containerId);
			CloseableHttpResponse resp = httpclient.execute(httpDelete);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				t = (new Gson()).fromJson(respString, cls);
				t.setSuccess(true);
			} else {
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				t = cls.newInstance();
				t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public <T extends GeneralHttpResp> T getConfig(String containerId, String version, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(resClusterInfo.getMarathonAddr() + MARATHON_APP_PATH + "/" + containerId + "/versions/" + version);
			CloseableHttpResponse resp = httpclient.execute(httpGet);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				t = (new Gson()).fromJson(respString, cls);
				t.setSuccess(true);
			} else {
				logger.info(respString);
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				t = cls.newInstance();
				t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public boolean registerService(String param) throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(resClusterInfo.getConsulAddr() + CONSUL_APP_PATH + "/register");
			StringEntity entity = new StringEntity(param, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPut.setEntity(entity);
			CloseableHttpResponse resp = httpclient.execute(httpPut);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			logger.info(respString);
			if (resp.getStatusLine().getStatusCode() == 200) {
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
	}

	@Override
	public boolean deRegisterService(String param) throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(resClusterInfo.getConsulAddr() + CONSUL_APP_PATH + "/deregister");
			StringEntity entity = new StringEntity(param, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPut.setEntity(entity);
			CloseableHttpResponse resp = httpclient.execute(httpPut);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			logger.info(respString);
			if (resp.getStatusLine().getStatusCode() == 200) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
	}

	@Override
	public List<ServiceInfo> getServiceInfo(String param) throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpPut = new HttpGet(resClusterInfo.getConsulAddr() + CONSUL_APP_PATH + "/service/" + param);

			CloseableHttpResponse resp = httpclient.execute(httpPut);
			String respString = EntityUtils.toString(resp.getEntity(), "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			logger.info(respString);
			if (resp.getStatusLine().getStatusCode() == 200) {
				return (new Gson()).fromJson(respString, new TypeToken<List<ServiceInfo>>() {
				}.getType());
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
	}

	@Override
	public GeneralHttpResp deployTimer(String createAppReq) throws RemoteServiceException {
		GeneralHttpResp t = new GeneralHttpResp();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/iso8601");
			StringEntity entity = new StringEntity(createAppReq, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			logger.info(createAppReq);
			CloseableHttpResponse resp = httpclient.execute(httpPost);
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 204) {
				t.setSuccess(true);
			} else {
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public GeneralHttpResp destroyTimer(String name) throws RemoteServiceException {
		GeneralHttpResp t = new GeneralHttpResp();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpDelete httpDelete = new HttpDelete(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/job/" + name);

			CloseableHttpResponse resp = httpclient.execute(httpDelete);
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 204) {
				t.setSuccess(true);
			} else {
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public GeneralHttpResp deployTimerDependency(String createAppReq) throws RemoteServiceException {
		GeneralHttpResp t = new GeneralHttpResp();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/dependency");

			StringEntity entity = new StringEntity(createAppReq, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			logger.info(createAppReq);
			CloseableHttpResponse resp = httpclient.execute(httpPost);
			// HttpEntity respEntity = resp.getEntity();
			// String respString = EntityUtils.toString(respEntity, "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 204) {
				t.setSuccess(true);
			} else {
				// FailedResp failedResp = (new Gson()).fromJson(respString,
				// FailedResp.class);
				// t.setFailedResp(failedResp);
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public GeneralHttpResp forceTimer(String name) throws RemoteServiceException {
		GeneralHttpResp t = new GeneralHttpResp();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/job/" + name);

			CloseableHttpResponse resp = httpclient.execute(httpPut);
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 204) {
				t.setSuccess(true);
			} else {
				t.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public JobsResp getTimerJobs() throws RemoteServiceException {
		JobsResp jobsResp = new JobsResp();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/jobs");

			CloseableHttpResponse resp = httpclient.execute(httpGet);
			HttpEntity respEntity = resp.getEntity();
			String respString = EntityUtils.toString(respEntity, "UTF-8");
			logger.info(resp.getStatusLine().getStatusCode());
			logger.info(respString);
			if (resp.getStatusLine().getStatusCode() == 200) {
				List<ChronosJob> jobs = (new Gson()).fromJson(respString, new TypeToken<List<ChronosJob>>() {
				}.getType());
				jobsResp.setJobs(jobs);
				jobsResp.setSuccess(true);
			} else {
				FailedResp failedResp = (new Gson()).fromJson(respString, FailedResp.class);
				jobsResp.setFailedResp(failedResp);
				jobsResp.setSuccess(false);
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
		return jobsResp;
	}

	@Override
	public boolean timerJobExist(String name) throws RemoteServiceException {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(resClusterInfo.getChronosAddr() + CHRONOS_APP_PATH + "/job/stat/" + name);

			CloseableHttpResponse resp = httpclient.execute(httpGet);
			logger.info(resp.getStatusLine().getStatusCode());
			if (resp.getStatusLine().getStatusCode() == 200) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new RemoteServiceException(e);
		}
	}
}
