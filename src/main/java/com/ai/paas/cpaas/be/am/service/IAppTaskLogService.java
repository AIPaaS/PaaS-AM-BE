package com.ai.paas.cpaas.be.am.service;

import java.util.List;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskLog;

public interface IAppTaskLogService {

	public void saveTaskLog(int taskId, String message);

	public List<AppTaskLog> getTaskLogs(int taskId);
}
