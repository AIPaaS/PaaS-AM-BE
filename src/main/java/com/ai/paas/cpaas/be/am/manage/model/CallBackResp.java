package com.ai.paas.cpaas.be.am.manage.model;

public class CallBackResp {
	private Boolean data;
	private Boolean success;
	private Integer errorCode;

	public Boolean getData() {
		return data;
	}

	public void setData(Boolean data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
