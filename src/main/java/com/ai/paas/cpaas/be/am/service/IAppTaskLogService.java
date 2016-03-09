package com.ai.paas.cpaas.be.am.service;

import java.util.List;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskLog;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;

public interface IAppTaskLogService {

	public void saveTaskLog(int taskId, String message,TaskStateType taskState);

	public List<AppTaskLog> getTaskLogs(int taskId);
}
