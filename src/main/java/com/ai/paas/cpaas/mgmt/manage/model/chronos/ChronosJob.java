package com.ai.paas.cpaas.mgmt.manage.model.chronos;

import java.util.List;

public class ChronosJob {
	private String name;
	private String command;
	private Boolean shell;
	private String description;
	private String schedule;
	private String owner;
	private String ownerName;
	private Boolean async;
	private String epsilon;
	private String executor;
	private String executorFlags;
	private Integer retries;
	private Boolean disabled;
	private Boolean softError;
	private String cpus;
	private String mem;
	private String disk;
	private String highPriority;
	private Integer successCount;
	private Integer errorCount;
	private String lastSuccess;
	private String lastError;
	private Boolean dataProcessingJobType;
	private Boolean errorsSinceLastSuccess;
	private List<String> parents;

	public Boolean getShell() {
		return shell;
	}

	public void setShell(Boolean shell) {
		this.shell = shell;
	}

	public String getExecutorFlags() {
		return executorFlags;
	}

	public void setExecutorFlags(String executorFlags) {
		this.executorFlags = executorFlags;
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public String getLastSuccess() {
		return lastSuccess;
	}

	public void setLastSuccess(String lastSuccess) {
		this.lastSuccess = lastSuccess;
	}

	public String getLastError() {
		return lastError;
	}

	public void setLastError(String lastError) {
		this.lastError = lastError;
	}

	public Boolean getDataProcessingJobType() {
		return dataProcessingJobType;
	}

	public void setDataProcessingJobType(Boolean dataProcessingJobType) {
		this.dataProcessingJobType = dataProcessingJobType;
	}

	public Boolean getErrorsSinceLastSuccess() {
		return errorsSinceLastSuccess;
	}

	public void setErrorsSinceLastSuccess(Boolean errorsSinceLastSuccess) {
		this.errorsSinceLastSuccess = errorsSinceLastSuccess;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Boolean getAsync() {
		return async;
	}

	public void setAsync(Boolean async) {
		this.async = async;
	}

	public String getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(String epsilon) {
		this.epsilon = epsilon;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getSoftError() {
		return softError;
	}

	public void setSoftError(Boolean softError) {
		this.softError = softError;
	}

	public String getCpus() {
		return cpus;
	}

	public void setCpus(String cpus) {
		this.cpus = cpus;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public String getHighPriority() {
		return highPriority;
	}

	public void setHighPriority(String highPriority) {
		this.highPriority = highPriority;
	}

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public static class Container {
		private String type = "DOCKER";
		private String image;
		private String network = "BRIDGE";
		
		private List<Volume> volumes;

		public static class Volume {
			private String containerPath;
			private String hostPath;
			private String mode;
		}
	}
}
