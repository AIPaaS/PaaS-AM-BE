package com.ai.paas.cpaas.mgmt.manage.model.marathon;

public class SimpleInfoResp extends GeneralResp {

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
