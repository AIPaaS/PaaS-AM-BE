package com.ai.paas.cpaas.mgmt.dao.mapper.bo;

import java.sql.Timestamp;

public class AppReqInfo {
    private Integer reqId;

    private String clusterId;

    private Integer actionType;

    private String reqCnt;

    private String reqResp;

    private Timestamp reqTime;

    private Timestamp respTime;

    private Integer reqState;

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId == null ? null : clusterId.trim();
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getReqCnt() {
        return reqCnt;
    }

    public void setReqCnt(String reqCnt) {
        this.reqCnt = reqCnt == null ? null : reqCnt.trim();
    }

    public String getReqResp() {
        return reqResp;
    }

    public void setReqResp(String reqResp) {
        this.reqResp = reqResp == null ? null : reqResp.trim();
    }

    public Timestamp getReqTime() {
        return reqTime;
    }

    public void setReqTime(Timestamp reqTime) {
        this.reqTime = reqTime;
    }

    public Timestamp getRespTime() {
        return respTime;
    }

    public void setRespTime(Timestamp respTime) {
        this.respTime = respTime;
    }

    public Integer getReqState() {
        return reqState;
    }

    public void setReqState(Integer reqState) {
        this.reqState = reqState;
    }
}