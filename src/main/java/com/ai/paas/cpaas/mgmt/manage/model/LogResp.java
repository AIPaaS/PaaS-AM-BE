package com.ai.paas.cpaas.mgmt.manage.model;

import java.util.List;

import com.ai.paas.ipaas.rest.vo.BaseResult;

public class LogResp extends BaseResult {
	private String actionType;
	private List<Task> tasks;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public static class Task {
		private String taskName;
		private String taskState;
		private String startTime;
		private String endTime;
		private List<Log> logs;

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public String getTaskState() {
			return taskState;
		}

		public void setTaskState(String taskState) {
			this.taskState = taskState;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		public List<Log> getLogs() {
			return logs;
		}

		public void setLogs(List<Log> logs) {
			this.logs = logs;
		}

	}

	public static class Log {
		private String logTime;
		private String logCnt;

		public String getLogTime() {
			return logTime;
		}

		public void setLogTime(String logTime) {
			this.logTime = logTime;
		}

		public String getLogCnt() {
			return logCnt;
		}

		public void setLogCnt(String logCnt) {
			this.logCnt = logCnt;
		}

	}
}
