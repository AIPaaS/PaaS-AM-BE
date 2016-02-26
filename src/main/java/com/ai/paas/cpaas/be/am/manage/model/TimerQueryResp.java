package com.ai.paas.cpaas.be.am.manage.model;

public class TimerQueryResp extends GeneralResp {
	private Integer successCount;
	private Integer errorCount;
	private String lastSuccess;
	private String lastError;
	private Integer errorsSinceLastSuccess;
	private String schedule;
	private String state;

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public String getLastSuccess() {
		return lastSuccess;
	}

	public void setLastSuccess(String lastSuccess) {
		this.lastSuccess = lastSuccess;
	}

	public String getLastError() {
		return lastError;
	}

	public void setLastError(String lastError) {
		this.lastError = lastError;
	}

	public Integer getErrorsSinceLastSuccess() {
		return errorsSinceLastSuccess;
	}

	public void setErrorsSinceLastSuccess(Integer errorsSinceLastSuccess) {
		this.errorsSinceLastSuccess = errorsSinceLastSuccess;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
