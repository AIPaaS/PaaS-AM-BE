package com.ai.paas.cpaas.be.am.manage.thread;

import org.apache.log4j.Logger;

import com.ai.paas.cpaas.be.am.manage.RunJobThread;
import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.marathon.GetConfigResp;
import com.ai.paas.cpaas.be.am.manage.model.marathon.SimpleInfoResp;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;

public class UpgradeApp extends RunJobThread<GetConfigResp> {
	private static Logger logger = Logger.getLogger(UpgradeApp.class);

	@Override
	protected boolean validate(Container container) {
		return true;
	}

	@Override
	protected GetConfigResp turnToMarathonReq(Container container) {
		GetConfigResp getConfigResp = null;
		try {
			getConfigResp = remoteService.getConfig(container.getContainerName(), container.getVersion(), GetConfigResp.class);
		} catch (RemoteServiceException e) {
			logger.error("can't find config info for " + container.getContainerName() + ",version:" + container.getVersion());
			return new GetConfigResp();
		}
		if (getConfigResp != null) {
			GetConfigResp.Container containerResp = getConfigResp.getContainer();
			if (containerResp != null) {
				GetConfigResp.Container.Docker docker = containerResp.getDocker();
				docker.setImage(container.getImgFullName() + ":" + container.getImgVersion());
			}
		}
		getConfigResp.setVersion(null);
		getConfigResp.setFailedResp(null);
		getConfigResp.setSuccess(null);
		return getConfigResp;
	}

	@Override
	protected GeneralHttpResp runJob(String containerId, String param) throws RemoteServiceException {
		return remoteService.putConfig(param, containerId, SimpleInfoResp.class);
	}

}
