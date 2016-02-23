package com.ai.paas.cpaas.mgmt.manage.thread;

import com.ai.paas.cpaas.mgmt.manage.RunJobThread;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.mgmt.manage.model.marathon.ChangeConfigReq;
import com.ai.paas.cpaas.mgmt.manage.model.marathon.SimpleInfoResp;
import com.ai.paas.cpaas.mgmt.service.RemoteServiceException;

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
