package com.ai.paas.cpaas.be.am.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.cpaas.be.am.dao.interfaces.AppTaskLogMapper;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskLog;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskLogCriteria;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskLogCriteria.Criteria;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;
import com.ai.paas.cpaas.be.am.service.IAppTaskLogService;
import com.ai.paas.ipaas.ServiceUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class AppTaskLogServiceImpl implements IAppTaskLogService {

	@Override
	public void saveTaskLog(int taskId, String message, TaskStateType taskState) {
		AppTaskLogMapper mapper = ServiceUtil.getMapper(AppTaskLogMapper.class);
		AppTaskLog appTaskLog = new AppTaskLog();
		appTaskLog.setLogCnt(message);
		appTaskLog.setTaskId(taskId);
		appTaskLog.setTaskState(taskState.getKey());
		appTaskLog.setLogTime(new Timestamp(System.currentTimeMillis()));
		mapper.insert(appTaskLog);
	}

	@Override
	public List<AppTaskLog> getTaskLogs(int taskId) {
		AppTaskLogMapper mapper = ServiceUtil.getMapper(AppTaskLogMapper.class);
		AppTaskLogCriteria appTaskLogCriteria = new AppTaskLogCriteria();
		Criteria criteria = appTaskLogCriteria.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		return mapper.selectByExample(appTaskLogCriteria);
	}

}
