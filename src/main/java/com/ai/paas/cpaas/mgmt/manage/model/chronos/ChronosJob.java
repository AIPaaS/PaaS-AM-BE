package com.ai.paas.cpaas.mgmt.manage.model.chronos;

import java.util.List;

import com.ai.paas.cpaas.mgmt.manage.model.Parameter;

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
	private List<Parameter> environmentVariables;
	private List<List<String>> constraints;
	private Container container;

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public List<Parameter> getEnvironmentVariables() {
		return environmentVariables;
	}

	public void setEnvironmentVariables(List<Parameter> environmentVariables) {
		this.environmentVariables = environmentVariables;
	}

	public List<List<String>> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<List<String>> constraints) {
		this.constraints = constraints;
	}

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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getNetwork() {
			return network;
		}

		public void setNetwork(String network) {
			this.network = network;
		}

		public List<Volume> getVolumes() {
			return volumes;
		}

		public void setVolumes(List<Volume> volumes) {
			this.volumes = volumes;
		}

		public static class Volume {
			private String containerPath;
			private String hostPath;
			private String mode;

			public Volume(String containerPath, String hostPath, String mode) {
				this.containerPath = containerPath;
				this.hostPath = hostPath;
				this.mode = mode;
			}

			public String getContainerPath() {
				return containerPath;
			}

			public void setContainerPath(String containerPath) {
				this.containerPath = containerPath;
			}

			public String getHostPath() {
				return hostPath;
			}

			public void setHostPath(String hostPath) {
				this.hostPath = hostPath;
			}

			public String getMode() {
				return mode;
			}

			public void setMode(String mode) {
				this.mode = mode;
			}

		}
	}
}
