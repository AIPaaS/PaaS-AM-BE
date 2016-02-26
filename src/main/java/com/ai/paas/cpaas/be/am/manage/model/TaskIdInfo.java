package com.ai.paas.cpaas.be.am.manage.model;

public class TaskIdInfo {
	private int taskId;
	private String containerId;

	public TaskIdInfo(int taskId, String containerId) {
		this.taskId = taskId;
		this.containerId = containerId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

}
