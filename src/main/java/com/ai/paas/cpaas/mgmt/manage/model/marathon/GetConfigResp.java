package com.ai.paas.cpaas.mgmt.manage.model.marathon;

import java.util.List;

import com.ai.paas.cpaas.mgmt.manage.model.Parameter;

public class GetConfigResp extends GeneralResp {
	private String id;
	private String cmd;
	private List<String> args;
	private String user;
	private Integer instances;
	private Integer cpus;
	private Integer mem;
	private Integer disk;
	private String executor;
	// private List<String> constraints;
	// private List<String> uris;
	private List<Integer> ports;
	private Boolean requirePorts;
	private Integer backoffSeconds;
	private Float backoffFactor;
	private Integer maxLaunchDelaySeconds;
	private String version;
	private Container container;
	private VersionInfo versionInfo;

	public VersionInfo getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(VersionInfo versionInfo) {
		this.versionInfo = versionInfo;
	}

	public static class VersionInfo {
		private String lastScalingAt;
		private String lastConfigChangeAt;

		public String getLastScalingAt() {
			return lastScalingAt;
		}

		public void setLastScalingAt(String lastScalingAt) {
			this.lastScalingAt = lastScalingAt;
		}

		public String getLastConfigChangeAt() {
			return lastConfigChangeAt;
		}

		public void setLastConfigChangeAt(String lastConfigChangeAt) {
			this.lastConfigChangeAt = lastConfigChangeAt;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public Integer getCpus() {
		return cpus;
	}

	public void setCpus(Integer cpus) {
		this.cpus = cpus;
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

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	// public List<String> getConstraints() {
	// return constraints;
	// }
	//
	// public void setConstraints(List<String> constraints) {
	// this.constraints = constraints;
	// }
	//
	// public List<String> getUris() {
	// return uris;
	// }
	//
	// public void setUris(List<String> uris) {
	// this.uris = uris;
	// }

	public List<Integer> getPorts() {
		return ports;
	}

	public void setPorts(List<Integer> ports) {
		this.ports = ports;
	}

	public Boolean getRequirePorts() {
		return requirePorts;
	}

	public void setRequirePorts(Boolean requirePorts) {
		this.requirePorts = requirePorts;
	}

	public Integer getBackoffSeconds() {
		return backoffSeconds;
	}

	public void setBackoffSeconds(Integer backoffSeconds) {
		this.backoffSeconds = backoffSeconds;
	}

	public Float getBackoffFactor() {
		return backoffFactor;
	}

	public void setBackoffFactor(Float backoffFactor) {
		this.backoffFactor = backoffFactor;
	}

	public Integer getMaxLaunchDelaySeconds() {
		return maxLaunchDelaySeconds;
	}

	public void setMaxLaunchDelaySeconds(Integer maxLaunchDelaySeconds) {
		this.maxLaunchDelaySeconds = maxLaunchDelaySeconds;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public static class Container {
		private String type;
		private Docker docker;
		private List<Volume> volumes;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Docker getDocker() {
			return docker;
		}

		public void setDocker(Docker docker) {
			this.docker = docker;
		}

		public List<Volume> getVolumes() {
			return volumes;
		}

		public void setVolumes(List<Volume> volumes) {
			this.volumes = volumes;
		}

		public static class Docker {
			private String image;
			private String network;
			private Boolean privileged;
			private List<PortMapping> portMappings;
			// private List<Parameter> parameters;

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

			public Boolean getPrivileged() {
				return privileged;
			}

			public void setPrivileged(Boolean privileged) {
				this.privileged = privileged;
			}

			public List<PortMapping> getPortMappings() {
				return portMappings;
			}

			public void setPortMappings(List<PortMapping> portMappings) {
				this.portMappings = portMappings;
			}

			// public List<Parameter> getParameters() {
			// return parameters;
			// }
			//
			// public void setParameters(List<Parameter> parameters) {
			// this.parameters = parameters;
			// }

			public static class PortMapping {
				private Integer containerPort;
				private Integer hostPort;
				private Integer servicePort;
				private String protocol;

				public Integer getContainerPort() {
					return containerPort;
				}

				public void setContainerPort(Integer containerPort) {
					this.containerPort = containerPort;
				}

				public Integer getHostPort() {
					return hostPort;
				}

				public void setHostPort(Integer hostPort) {
					this.hostPort = hostPort;
				}

				public Integer getServicePort() {
					return servicePort;
				}

				public void setServicePort(Integer servicePort) {
					this.servicePort = servicePort;
				}

				public String getProtocol() {
					return protocol;
				}

				public void setProtocol(String protocol) {
					this.protocol = protocol;
				}

			}
		}

		public static class Volume {
			private String containerPath;
			private String hostPath;
			private String mode;

			public Volume() {

			}

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

	public static class UpgradeStrategy {
		private Double minimumHealthCapacity;
		private Double maximumOverCapacity;

		public Double getMinimumHealthCapacity() {
			return minimumHealthCapacity;
		}

		public void setMinimumHealthCapacity(Double minimumHealthCapacity) {
			this.minimumHealthCapacity = minimumHealthCapacity;
		}

		public Double getMaximumOverCapacity() {
			return maximumOverCapacity;
		}

		public void setMaximumOverCapacity(Double maximumOverCapacity) {
			this.maximumOverCapacity = maximumOverCapacity;
		}

	}
}
