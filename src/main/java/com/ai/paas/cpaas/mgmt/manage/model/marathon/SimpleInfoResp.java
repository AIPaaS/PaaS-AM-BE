package com.ai.paas.cpaas.mgmt.manage.model.marathon;

import com.ai.paas.cpaas.mgmt.manage.model.GeneralHttpResp;

public class SimpleInfoResp extends GeneralHttpResp {

	private String deploymentId;
	private String version;

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
