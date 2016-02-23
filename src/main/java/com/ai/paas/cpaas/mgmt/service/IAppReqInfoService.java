package com.ai.paas.cpaas.mgmt.service;

import com.ai.paas.cpaas.mgmt.dao.mapper.bo.AppReqInfo;
import com.ai.paas.cpaas.mgmt.manage.model.ActionType;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralReq;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralDeployResp;

public interface IAppReqInfoService {
	 
	public int saveReqInfo(GeneralReq createReq,String param,ActionType actionType);
	
	public void saveReqInfo(AppReqInfo appReqInfo);
	
	public void updateReqInfo(int reqId,GeneralDeployResp generalResp);
	
	public AppReqInfo getReqInfo(int reqId);
}
