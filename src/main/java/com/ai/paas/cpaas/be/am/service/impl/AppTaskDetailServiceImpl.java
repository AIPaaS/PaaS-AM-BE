package com.ai.paas.cpaas.be.am.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.cpaas.be.am.dao.interfaces.AppTaskDetailMapper;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetail;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetailCriteria;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetailCriteria.Criteria;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;
import com.ai.paas.cpaas.be.am.service.IAppTaskDetailService;
import com.ai.paas.ipaas.ServiceUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class AppTaskDetailServiceImpl implements IAppTaskDetailService {

	@Override
	public int saveAppTaskDetail(int reqId, String appId, String taskName, String taskJson, TaskStateType taskState) {
		AppTaskDetailMapper mapper = ServiceUtil.getMapper(AppTaskDetailMapper.class);
		AppTaskDetail appTaskDetail = new AppTaskDetail();
		appTaskDetail.setAppId(appId);
		appTaskDetail.setReqId(reqId);
		appTaskDetail.setTaskName(taskName);
		appTaskDetail.setTaskJson(taskJson);
		appTaskDetail.setTaskStartTime(new Timestamp(System.currentTimeMillis()));
		appTaskDetail.setTaskState(taskState.getKey());
		mapper.insert(appTaskDetail);
		return appTaskDetail.getTaskId();
	}

	@Override
	public void updateAppTaskDetail(int taskId, TaskStateType taskState) {
		AppTaskDetailMapper mapper = ServiceUtil.getMapper(AppTaskDetailMapper.class);
		AppTaskDetail appTaskDetail = new AppTaskDetail();
		appTaskDetail.setTaskId(taskId);
		appTaskDetail.setTaskState(taskState.getKey());
		appTaskDetail.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
		mapper.updateByPrimaryKeySelective(appTaskDetail);
	}

	@Override
	public List<AppTaskDetail> getTasksByApp(String appId) {
		AppTaskDetailMapper mapper = ServiceUtil.getMapper(AppTaskDetailMapper.class);
		AppTaskDetailCriteria appTaskDetailCriteria = new AppTaskDetailCriteria();
		Criteria criteria = appTaskDetailCriteria.createCriteria();
		criteria.andAppIdEqualTo(appId);
		return mapper.selectByExample(appTaskDetailCriteria);
	}

	@Override
	public List<AppTaskDetail> getTasksByReq(int reqId) {
		AppTaskDetailMapper mapper = ServiceUtil.getMapper(AppTaskDetailMapper.class);
		AppTaskDetailCriteria appTaskDetailCriteria = new AppTaskDetailCriteria();
		Criteria criteria = appTaskDetailCriteria.createCriteria();
		criteria.andReqIdEqualTo(reqId);
		return mapper.selectByExample(appTaskDetailCriteria);
	}

}
