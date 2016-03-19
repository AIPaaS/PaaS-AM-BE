package com.ai.paas.cpaas.be.am.manage.model.marathon;

import java.util.List;

import com.ai.paas.cpaas.be.am.manage.model.Parameter;
import com.google.gson.Gson;

public class CreateAppReq {
	private String id;
	private String cmd;
	private List<String> args;
	private Double cpus;
	private Integer mem;
	private List<Integer> ports;
	private Boolean requirePorts;
	private Integer instances;
	private String executor;
	private Container container;
	private List<List<String>> constraints;
	private List<String> acceptedResourceRoles;
	private List<String> uris;
	private List<String> dependencies;
	private List<HealthCheck> healthChecks;
	private String backoffSeconds = "100";
	private Double backoffFactor = 1.15d;
	private Integer maxLaunchDelaySeconds =3600;
	private UpgradeStrategy upgradeStrategy;

	public String toJson() {
		return (new Gson()).toJson(this);
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

	public Double getCpus() {
		return cpus;
	}

	public void setCpus(Double cpus) {
		this.cpus = cpus;
	}

	public Integer getMem() {
		return mem;
	}

	public void setMem(Integer mem) {
		this.mem = mem;
	}

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

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public List<List<String>> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<List<String>> constraints) {
		this.constraints = constraints;
	}

	public List<String> getAcceptedResourceRoles() {
		return acceptedResourceRoles;
	}

	public void setAcceptedResourceRoles(List<String> acceptedResourceRoles) {
		this.acceptedResourceRoles = acceptedResourceRoles;
	}

	public List<String> getUris() {
		return uris;
	}

	public void setUris(List<String> uris) {
		this.uris = uris;
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public List<HealthCheck> getHealthChecks() {
		return healthChecks;
	}

	public void setHealthChecks(List<HealthCheck> healthChecks) {
		this.healthChecks = healthChecks;
	}

	public String getBackoffSeconds() {
		return backoffSeconds;
	}

	public void setBackoffSeconds(String backoffSeconds) {
		this.backoffSeconds = backoffSeconds;
	}

	public Double getBackoffFactor() {
		return backoffFactor;
	}

	public void setBackoffFactor(Double backoffFactor) {
		this.backoffFactor = backoffFactor;
	}

	public Integer getMaxLaunchDelaySeconds() {
		return maxLaunchDelaySeconds;
	}

	public void setMaxLaunchDelaySeconds(Integer maxLaunchDelaySeconds) {
		this.maxLaunchDelaySeconds = maxLaunchDelaySeconds;
	}

	public UpgradeStrategy getUpgradeStrategy() {
		return upgradeStrategy;
	}

	public void setUpgradeStrategy(UpgradeStrategy upgradeStrategy) {
		this.upgradeStrategy = upgradeStrategy;
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
			private List<Parameter> parameters;

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

			public List<Parameter> getParameters() {
				return parameters;
			}

			public void setParameters(List<Parameter> parameters) {
				this.parameters = parameters;
			}

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

	public static class HealthCheck {
		private String protocol;
		private String path;
		private Integer gracePeriodSeconds;
		private Integer intervalSeconds;
		private Integer portIndex;
		private Integer timeoutSeconds;
		private Integer maxConsecutiveFailures;

		public String getProtocol() {
			return protocol;
		}

		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Integer getGracePeriodSeconds() {
			return gracePeriodSeconds;
		}

		public void setGracePeriodSeconds(Integer gracePeriodSeconds) {
			this.gracePeriodSeconds = gracePeriodSeconds;
		}

		public Integer getIntervalSeconds() {
			return intervalSeconds;
		}

		public void setIntervalSeconds(Integer intervalSeconds) {
			this.intervalSeconds = intervalSeconds;
		}

		public Integer getPortIndex() {
			return portIndex;
		}

		public void setPortIndex(Integer portIndex) {
			this.portIndex = portIndex;
		}

		public Integer getTimeoutSeconds() {
			return timeoutSeconds;
		}

		public void setTimeoutSeconds(Integer timeoutSeconds) {
			this.timeoutSeconds = timeoutSeconds;
		}

		public Integer getMaxConsecutiveFailures() {
			return maxConsecutiveFailures;
		}

		public void setMaxConsecutiveFailures(Integer maxConsecutiveFailures) {
			this.maxConsecutiveFailures = maxConsecutiveFailures;
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
