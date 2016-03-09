package com.ai.paas.cpaas.be.am.manage.model;

public class LogReq extends GeneralReq {
	private String lastFetchTime;
	private Integer reqId;

	public Integer getReqId() {
		return reqId;
	}

	public String getLastFetchTime() {
		return lastFetchTime;
	}

	public void setLastFetchTime(String lastFetchTime) {
		this.lastFetchTime = lastFetchTime;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

}
