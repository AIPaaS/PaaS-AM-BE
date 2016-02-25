package com.ai.paas.cpaas.mgmt.service.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.cpaas.mgmt.dao.interfaces.AppReqInfoMapper;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.AppReqInfo;
import com.ai.paas.cpaas.mgmt.manage.model.ActionType;
import com.ai.paas.cpaas.mgmt.manage.model.GeneralDeployResp;
import com.ai.paas.cpaas.mgmt.service.IAppReqInfoService;
import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.ServiceUtil;
import com.google.gson.Gson;

@Service
@Transactional(rollbackFor = Exception.class)
public class AppReqInfoServiceImpl implements IAppReqInfoService {

	@Override
	public int saveReqInfo(String clusterId, String param, ActionType actionType) {
		AppReqInfoMapper mapper = ServiceUtil.getMapper(AppReqInfoMapper.class);
		AppReqInfo appReqInfo = new AppReqInfo();
		appReqInfo.setClusterId(clusterId);
		appReqInfo.setActionType(actionType.getValue());
		appReqInfo.setReqCnt(param);
		appReqInfo.setReqTime(new Timestamp(System.currentTimeMillis()));
		mapper.insert(appReqInfo);
		return appReqInfo.getReqId();
	}

	@Override
	public void updateReqInfo(int reqId, GeneralDeployResp baseResult) {
		AppReqInfoMapper mapper = ServiceUtil.getMapper(AppReqInfoMapper.class);
		AppReqInfo appReqInfo = new AppReqInfo();
		appReqInfo.setReqResp((new Gson()).toJson(baseResult));
		appReqInfo.setRespTime(new Timestamp(System.currentTimeMillis()));
		appReqInfo.setReqId(reqId);
		if (PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(baseResult.getResultCode()))
			appReqInfo.setReqState(0);
		else
			appReqInfo.setReqState(1);
		mapper.updateByPrimaryKeySelective(appReqInfo);
	}

	@Override
	public void saveReqInfo(AppReqInfo appReqInfo) {

	}

	@Override
	public AppReqInfo getReqInfo(int reqId) {
		AppReqInfoMapper mapper = ServiceUtil.getMapper(AppReqInfoMapper.class);
		return mapper.selectByPrimaryKey(reqId);
	}

}
