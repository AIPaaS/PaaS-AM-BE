package com.ai.paas.cpaas.be.am.service;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppReqInfo;
import com.ai.paas.cpaas.be.am.manage.model.ActionType;
import com.ai.paas.cpaas.be.am.manage.model.GeneralDeployResp;

public interface IAppReqInfoService {

	public int saveReqInfo(String clusterId, String param, ActionType actionType);

	public void saveReqInfo(AppReqInfo appReqInfo);

	public void updateReqInfo(int reqId, GeneralDeployResp generalResp);

	public AppReqInfo getReqInfo(int reqId);
}
