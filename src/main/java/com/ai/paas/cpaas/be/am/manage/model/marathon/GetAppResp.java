package com.ai.paas.cpaas.be.am.manage.model.marathon;

import java.util.List;

import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;

public class GetAppResp extends GeneralHttpResp {
	private App app;

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public static class App {
		private String id;
		private int instances;
		private double cpus;
		private double mem;
		private double disk;
		private String executor;
		private List<List<String>> constraints;
		private List<String> uris;
		private List<String> storeUrls;
		private List<Integer> ports;
		private boolean requirePorts;
		private int backoffSeconds;
		private double backoffFactor;
		private int maxLaunchDelaySeconds;
		private Container container;
		private List<String> healthChecks;
		private List<String> dependencies;
		private UpgradeStrategy upgradeStrategy;
		private String version;
		private VersionInfo versionInfo;
		private int tasksStaged;
		private int tasksRunning;
		private int tasksHealthy;
		private int tasksUnhealthy;
		private List<Deployment> deployments;
		private List<Task> tasks;
		private LastTaskFailure lastTaskFailure;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getInstances() {
			return instances;
		}

		public void setInstances(int instances) {
			this.instances = instances;
		}

		public double getCpus() {
			return cpus;
		}

		public void setCpus(double cpus) {
			this.cpus = cpus;
		}

		public double getMem() {
			return mem;
		}

		public void setMem(double mem) {
			this.mem = mem;
		}

		public double getDisk() {
			return disk;
		}

		public void setDisk(double disk) {
			this.disk = disk;
		}

		public String getExecutor() {
			return executor;
		}

		public void setExecutor(String executor) {
			this.executor = executor;
		}

		public List<List<String>> getConstraints() {
			return constraints;
		}

		public void setConstraints(List<List<String>> constraints) {
			this.constraints = constraints;
		}

		public List<String> getUris() {
			return uris;
		}

		public void setUris(List<String> uris) {
			this.uris = uris;
		}

		public List<String> getStoreUrls() {
			return storeUrls;
		}

		public void setStoreUrls(List<String> storeUrls) {
			this.storeUrls = storeUrls;
		}

		public List<Integer> getPorts() {
			return ports;
		}

		public void setPorts(List<Integer> ports) {
			this.ports = ports;
		}

		public boolean isRequirePorts() {
			return requirePorts;
		}

		public void setRequirePorts(boolean requirePorts) {
			this.requirePorts = requirePorts;
		}

		public int getBackoffSeconds() {
			return backoffSeconds;
		}

		public void setBackoffSeconds(int backoffSeconds) {
			this.backoffSeconds = backoffSeconds;
		}

		public double getBackoffFactor() {
			return backoffFactor;
		}

		public void setBackoffFactor(double backoffFactor) {
			this.backoffFactor = backoffFactor;
		}

		public int getMaxLaunchDelaySeconds() {
			return maxLaunchDelaySeconds;
		}

		public void setMaxLaunchDelaySeconds(int maxLaunchDelaySeconds) {
			this.maxLaunchDelaySeconds = maxLaunchDelaySeconds;
		}

		public Container getContainer() {
			return container;
		}

		public void setContainer(Container container) {
			this.container = container;
		}

		public List<String> getHealthChecks() {
			return healthChecks;
		}

		public void setHealthChecks(List<String> healthChecks) {
			this.healthChecks = healthChecks;
		}

		public List<String> getDependencies() {
			return dependencies;
		}

		public void setDependencies(List<String> dependencies) {
			this.dependencies = dependencies;
		}

		public UpgradeStrategy getUpgradeStrategy() {
			return upgradeStrategy;
		}

		public void setUpgradeStrategy(UpgradeStrategy upgradeStrategy) {
			this.upgradeStrategy = upgradeStrategy;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public VersionInfo getVersionInfo() {
			return versionInfo;
		}

		public void setVersionInfo(VersionInfo versionInfo) {
			this.versionInfo = versionInfo;
		}

		public int getTasksStaged() {
			return tasksStaged;
		}

		public void setTasksStaged(int tasksStaged) {
			this.tasksStaged = tasksStaged;
		}

		public int getTasksRunning() {
			return tasksRunning;
		}

		public void setTasksRunning(int tasksRunning) {
			this.tasksRunning = tasksRunning;
		}

		public int getTasksHealthy() {
			return tasksHealthy;
		}

		public void setTasksHealthy(int tasksHealthy) {
			this.tasksHealthy = tasksHealthy;
		}

		public int getTasksUnhealthy() {
			return tasksUnhealthy;
		}

		public void setTasksUnhealthy(int tasksUnhealthy) {
			this.tasksUnhealthy = tasksUnhealthy;
		}

		public List<Deployment> getDeployments() {
			return deployments;
		}

		public void setDeployments(List<Deployment> deployments) {
			this.deployments = deployments;
		}

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}

		public LastTaskFailure getLastTaskFailure() {
			return lastTaskFailure;
		}

		public void setLastTaskFailure(LastTaskFailure lastTaskFailure) {
			this.lastTaskFailure = lastTaskFailure;
		}

		public static class Container {
			private String type;

			private List<Volume> volumes;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public List<Volume> getVolumes() {
				return volumes;
			}

			public void setVolumes(List<Volume> volumes) {
				this.volumes = volumes;
			}

		}

		public static class Volume {
			private String containerPath;
			private String hostPath;
			private String mode;

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

		public static class UpgradeStrategy {
			private double minimumHealthCapacity;

			private double maximumOverCapacity;

			public void setMinimumHealthCapacity(double minimumHealthCapacity) {
				this.minimumHealthCapacity = minimumHealthCapacity;
			}

			public double getMinimumHealthCapacity() {
				return this.minimumHealthCapacity;
			}

			public void setMaximumOverCapacity(double maximumOverCapacity) {
				this.maximumOverCapacity = maximumOverCapacity;
			}

			public double getMaximumOverCapacity() {
				return this.maximumOverCapacity;
			}

		}

		public static class VersionInfo {
			private String lastScalingAt;

			private String lastConfigChangeAt;

			public void setLastScalingAt(String lastScalingAt) {
				this.lastScalingAt = lastScalingAt;
			}

			public String getLastScalingAt() {
				return this.lastScalingAt;
			}

			public void setLastConfigChangeAt(String lastConfigChangeAt) {
				this.lastConfigChangeAt = lastConfigChangeAt;
			}

			public String getLastConfigChangeAt() {
				return this.lastConfigChangeAt;
			}

		}

		public static class Deployment {
			private String id;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}
		}

		public static class Task {
			private String id;

			private String host;

			private List<Integer> ports;

			private String startedAt;

			private String stagedAt;

			private String version;

			private String slaveId;

			private String appId;

			public List<Integer> getPorts() {
				return ports;
			}

			public void setPorts(List<Integer> ports) {
				this.ports = ports;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getId() {
				return this.id;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public String getHost() {
				return this.host;
			}

			public void setStartedAt(String startedAt) {
				this.startedAt = startedAt;
			}

			public String getStartedAt() {
				return this.startedAt;
			}

			public void setStagedAt(String stagedAt) {
				this.stagedAt = stagedAt;
			}

			public String getStagedAt() {
				return this.stagedAt;
			}

			public void setVersion(String version) {
				this.version = version;
			}

			public String getVersion() {
				return this.version;
			}

			public void setSlaveId(String slaveId) {
				this.slaveId = slaveId;
			}

			public String getSlaveId() {
				return this.slaveId;
			}

			public void setAppId(String appId) {
				this.appId = appId;
			}

			public String getAppId() {
				return this.appId;
			}

		}

		public static class LastTaskFailure {
			private String appId;

			private String host;

			private String message;

			private String state;

			private String taskId;

			private String timestamp;

			private String version;

			private String slaveId;

			public void setAppId(String appId) {
				this.appId = appId;
			}

			public String getAppId() {
				return this.appId;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public String getHost() {
				return this.host;
			}

			public void setMessage(String message) {
				this.message = message;
			}

			public String getMessage() {
				return this.message;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getState() {
				return this.state;
			}

			public void setTaskId(String taskId) {
				this.taskId = taskId;
			}

			public String getTaskId() {
				return this.taskId;
			}

			public void setTimestamp(String timestamp) {
				this.timestamp = timestamp;
			}

			public String getTimestamp() {
				return this.timestamp;
			}

			public void setVersion(String version) {
				this.version = version;
			}

			public String getVersion() {
				return this.version;
			}

			public void setSlaveId(String slaveId) {
				this.slaveId = slaveId;
			}

			public String getSlaveId() {
				return this.slaveId;
			}

		}
	}
}
