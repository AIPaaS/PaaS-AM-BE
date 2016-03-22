package com.ai.paas.cpaas.be.am.manage.thread;

import com.ai.paas.cpaas.be.am.manage.RunJobThread;
import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.TaskIdInfo;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;
import com.ai.paas.cpaas.be.am.manage.model.marathon.GetAppResp;
import com.ai.paas.cpaas.be.am.manage.model.marathon.SimpleInfoResp;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;

public class DestroyApp extends RunJobThread<Object> {

	@Override
	protected Object turnToMarathonReq(Container container) {
		Object destroyReq = new Object();
		return destroyReq;
	}

	@Override
	protected boolean validate(Container container) {
		return true;
	}

	@Override
	protected GeneralHttpResp runJob(String containerId, String param) throws RemoteServiceException {
		return remoteService.destroyLongRun(containerId, SimpleInfoResp.class);
	}

	@Override
	protected void getInfoFailed(TaskIdInfo taskIdInfo, GetAppResp getAppResp) {
		appTaskDetailService.updateAppTaskDetail(taskIdInfo.getTaskId(), TaskStateType.SUCCESS);
		appTaskLogService.saveTaskLog(taskIdInfo.getTaskId(), "success destroy container ", TaskStateType.SUCCESS);
	}

}
