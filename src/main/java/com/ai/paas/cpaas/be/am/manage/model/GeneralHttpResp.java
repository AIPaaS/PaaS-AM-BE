package com.ai.paas.cpaas.be.am.manage.model;

import com.ai.paas.cpaas.be.am.manage.model.marathon.FailedResp;

public class GeneralHttpResp {
	private Boolean success;
	private FailedResp failedResp;

	public String getFailedMessage() {
		return failedResp.getMessage();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public FailedResp getFailedResp() {
		return failedResp;
	}

	public void setFailedResp(FailedResp failedResp) {
		this.failedResp = failedResp;
	}

}
