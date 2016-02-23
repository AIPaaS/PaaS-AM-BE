package com.ai.paas.cpaas.mgmt.manage.thread;

import com.ai.paas.cpaas.mgmt.manage.RunJobThread;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.mgmt.manage.model.marathon.SimpleInfoResp;
import com.ai.paas.cpaas.mgmt.service.RemoteServiceException;

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

}
