package com.ai.paas.cpaas.be.am.manage.model;

import java.util.List;

public class GeneralTimerReq {
	private String clusterId;
	private String clusterName;
	private String dataCenterId;
	private String dataCenterName;
	private String appId;
	private String appName;
	private String appNameCN;

	private String depends;
	private String start;
	private String repeatNum;
	private String period;
	private Integer retries;
	private String commond;
	private Container container;

	public String getCommond() {
		return commond;
	}

	public void setCommond(String commond) {
		this.commond = commond;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(String dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public String getDataCenterName() {
		return dataCenterName;
	}

	public void setDataCenterName(String dataCenterName) {
		this.dataCenterName = dataCenterName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppNameCN() {
		return appNameCN;
	}

	public void setAppNameCN(String appNameCN) {
		this.appNameCN = appNameCN;
	}

	public String getDepends() {
		return depends;
	}

	public void setDepends(String depends) {
		this.depends = depends;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getRepeatNum() {
		return repeatNum;
	}

	public void setRepeatNum(String repeatNum) {
		this.repeatNum = repeatNum;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public static class Container {
		private String containerId;
		private String containerName;
		private String zoneId;
		private String attrs;
		private String imgFullName;
		private String cpu;
		private String mem;
		private String disk;
		private String logDir;
		private String dataDir;
		private List<EnvironmentVariable> envVars;

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

		public String getZoneId() {
			return zoneId;
		}

		public void setZoneId(String zoneId) {
			this.zoneId = zoneId;
		}

		public String getAttrs() {
			return attrs;
		}

		public void setAttrs(String attrs) {
			this.attrs = attrs;
		}

		public String getImgFullName() {
			return imgFullName;
		}

		public void setImgFullName(String imgFullName) {
			this.imgFullName = imgFullName;
		}

		public String getCpu() {
			return cpu;
		}

		public void setCpu(String cpu) {
			this.cpu = cpu;
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

		public String getLogDir() {
			return logDir;
		}

		public void setLogDir(String logDir) {
			this.logDir = logDir;
		}

		public String getDataDir() {
			return dataDir;
		}

		public void setDataDir(String dataDir) {
			this.dataDir = dataDir;
		}

		public List<EnvironmentVariable> getEnvVars() {
			return envVars;
		}

		public void setEnvVars(List<EnvironmentVariable> envVars) {
			this.envVars = envVars;
		}

	}
}
