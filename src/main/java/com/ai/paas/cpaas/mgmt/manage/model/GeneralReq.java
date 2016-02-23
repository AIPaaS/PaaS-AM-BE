package com.ai.paas.cpaas.mgmt.manage.model;

import java.util.List;

public class GeneralReq {
	private String clusterId;
	private String clusterName;
	private String dataCenterId;
	private String dataCenterName;
	private String appId;
	private String appName;
	private String appNameCN;

	private List<Container> containers;

	public static class Container {
		private String containerId;
		private String containerName;
		private String action;
		private String zoneId;
		private List<Parameter> attrs;
		private String imgFullName;
		private String imgVersion;
		private String depends;
		private Double cpu;
		private Integer mem;
		private Integer disk;
		private Integer instances;
		private Integer maxInst;
		private Integer minInst;
		private Integer scaleOutCpu;
		private Integer scaleInCpu;
		private String logDir;
		private String dataDir;
		private String version;
		private List<Parameter> params;
		private List<Check> heathCheck;
		private List<For> servicesFor;
		private List<Service> services;

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public List<Parameter> getParams() {
			return params;
		}

		public void setParams(List<Parameter> params) {
			this.params = params;
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

		public String getZoneId() {
			return zoneId;
		}

		public void setZoneId(String zoneId) {
			this.zoneId = zoneId;
		}

		public List<Parameter> getAttrs() {
			return attrs;
		}

		public void setAttrs(List<Parameter> attrs) {
			this.attrs = attrs;
		}

		public String getImgFullName() {
			return imgFullName;
		}

		public void setImgFullName(String imgFullName) {
			this.imgFullName = imgFullName;
		}

		public String getImgVersion() {
			return imgVersion;
		}

		public void setImgVersion(String imgVersion) {
			this.imgVersion = imgVersion;
		}

		public String getDepends() {
			return depends;
		}

		public void setDepends(String depends) {
			this.depends = depends;
		}

		public Double getCpu() {
			return cpu;
		}

		public void setCpu(Double cpu) {
			this.cpu = cpu;
		}

		public Integer getMem() {
			return mem;
		}

		public void setMem(Integer mem) {
			this.mem = mem;
		}

		public Integer getDisk() {
			return disk;
		}

		public void setDisk(Integer disk) {
			this.disk = disk;
		}

		public Integer getInstances() {
			return instances;
		}

		public void setInstances(Integer instances) {
			this.instances = instances;
		}

		public Integer getMaxInst() {
			return maxInst;
		}

		public void setMaxInst(Integer maxInst) {
			this.maxInst = maxInst;
		}

		public Integer getMinInst() {
			return minInst;
		}

		public void setMinInst(Integer minInst) {
			this.minInst = minInst;
		}

		public Integer getScaleOutCpu() {
			return scaleOutCpu;
		}

		public void setScaleOutCpu(Integer scaleOutCpu) {
			this.scaleOutCpu = scaleOutCpu;
		}

		public Integer getScaleInCpu() {
			return scaleInCpu;
		}

		public void setScaleInCpu(Integer scaleInCpu) {
			this.scaleInCpu = scaleInCpu;
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

		public List<Check> getHeathCheck() {
			return heathCheck;
		}

		public void setHeathCheck(List<Check> heathCheck) {
			this.heathCheck = heathCheck;
		}

		public List<For> getServicesFor() {
			return servicesFor;
		}

		public void setServicesFor(List<For> servicesFor) {
			this.servicesFor = servicesFor;
		}

		public List<Service> getServices() {
			return services;
		}

		public void setServices(List<Service> services) {
			this.services = services;
		}

		public class Check {
			private String checkUrl;
			private String protocol;

			public String getCheckUrl() {
				return checkUrl;
			}

			public void setCheckUrl(String checkUrl) {
				this.checkUrl = checkUrl;
			}

			public String getProtocol() {
				return protocol;
			}

			public void setProtocol(String protocol) {
				this.protocol = protocol;
			}

		}

		public static class For {
			private String srvName;
			private String protocol;
			private Integer port;
			private List<Parameter> srvParams;

			public List<Parameter> getSrvParams() {
				return srvParams;
			}

			public void setSrvParams(List<Parameter> srvParams) {
				this.srvParams = srvParams;
			}

			public String getSrvName() {
				return srvName;
			}

			public void setSrvName(String srvName) {
				this.srvName = srvName;
			}

			public String getProtocol() {
				return protocol;
			}

			public void setProtocol(String protocol) {
				this.protocol = protocol;
			}

			public Integer getPort() {
				return port;
			}

			public void setPort(Integer port) {
				this.port = port;
			}

		}

		public static class Service {
			private String srvName;
			private String srvType;
			private String relation;
			private List<Parameter> params;

			public List<Parameter> getParams() {
				return params;
			}

			public void setParams(List<Parameter> params) {
				this.params = params;
			}

			public String getSrvName() {
				return srvName;
			}

			public void setSrvName(String srvName) {
				this.srvName = srvName;
			}

			public String getSrvType() {
				return srvType;
			}

			public void setSrvType(String srvType) {
				this.srvType = srvType;
			}

			public String getRelation() {
				return relation;
			}

			public void setRelation(String relation) {
				this.relation = relation;
			}
		}
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
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

}
