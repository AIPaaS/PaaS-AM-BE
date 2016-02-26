package com.ai.paas.cpaas.be.am.manage.thread;

import com.ai.paas.cpaas.be.am.manage.RunJobThread;
import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.marathon.ChangeConfigReq;
import com.ai.paas.cpaas.be.am.manage.model.marathon.SimpleInfoResp;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;

public class ScaleApp extends RunJobThread<ChangeConfigReq> {

	protected ChangeConfigReq turnToMarathonReq(Container container) {
		ChangeConfigReq changeConfigReq = new ChangeConfigReq();
		changeConfigReq.setInstances(container.getInstances());
		return changeConfigReq;
	}

	@Override
	protected boolean validate(Container container) {
		return true;
	}

	@Override
	protected GeneralHttpResp runJob(String containerId, String param) throws RemoteServiceException {
		return remoteService.putConfig(param, containerId, SimpleInfoResp.class);
	}

}
