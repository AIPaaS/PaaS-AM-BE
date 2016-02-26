package com.ai.paas.cpaas.be.am.manage.model;

import java.util.List;

/**
 * callback request
 * 
 * @author bixy
 *
 */
public class CallBackReq {
	private String clusterId;
	private String dataCenterId;
	private String appId;
	private String actionType;
	private List<Container> containers;

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(String dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public static class Container {
		private String containerId;
		private String containerName;
		private Integer instancesNum;
		private List<Instance> instances;
		private String state;
		private String message;
		private String version;

		public static class Instance {
			private String state;
			private String host;
			private String instanceId;

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getHost() {
				return host;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public String getInstanceId() {
				return instanceId;
			}

			public void setInstanceId(String instanceId) {
				this.instanceId = instanceId;
			}

		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public Integer getInstancesNum() {
			return instancesNum;
		}

		public void setInstancesNum(Integer instancesNum) {
			this.instancesNum = instancesNum;
		}

		public List<Instance> getInstances() {
			return instances;
		}

		public void setInstances(List<Instance> instances) {
			this.instances = instances;
		}

		public String getContainerId() {
			return containerId;
		}

		public void setContainerId(String containerId) {
			this.containerId = containerId;
		}

		public String getContainerName() {
			return containerName;
		}

		public void setContainerName(String containerName) {
			this.containerName = containerName;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
