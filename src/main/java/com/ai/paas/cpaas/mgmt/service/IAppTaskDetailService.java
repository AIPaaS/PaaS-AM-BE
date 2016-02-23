package com.ai.paas.cpaas.mgmt.service;

import java.util.List;

import com.ai.paas.cpaas.mgmt.dao.mapper.bo.AppTaskDetail;
import com.ai.paas.cpaas.mgmt.manage.model.TaskStateType;

public interface IAppTaskDetailService {

	public int saveAppTaskDetail(int reqId, String appId,String taskName,String taskJson, TaskStateType taskState);

	public void updateAppTaskDetail(int taskId, TaskStateType taskState);
	
	public List<AppTaskDetail> getTasksByApp(String appId);
	
	public List<AppTaskDetail> getTasksByReq(int reqId);
}
