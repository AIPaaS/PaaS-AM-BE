package com.ai.paas.cpaas.mgmt.service;

import java.util.List;

import com.ai.paas.cpaas.mgmt.dao.mapper.bo.AppTaskLog;

public interface IAppTaskLogService {

	public void saveTaskLog(int taskId, String message);

	public List<AppTaskLog> getTaskLogs(int taskId);
}
