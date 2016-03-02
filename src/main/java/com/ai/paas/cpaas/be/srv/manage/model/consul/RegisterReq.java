package com.ai.paas.cpaas.be.srv.manage.model.consul;

import java.util.List;

public class RegisterReq {
	private String node;
	private String address;
	private String serviceId;
	private Service service;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public static class Service {
		private String id;
		private String service;
		private List<String> tags;
		private String address;
		private Integer port;
		private List<Check> checks;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public List<String> getTags() {
			return tags;
		}

		public void setTags(List<String> tags) {
			this.tags = tags;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public List<Check> getChecks() {
			return checks;
		}

		public void setChecks(List<Check> checks) {
			this.checks = checks;
		}

		public static class Check {
			private String script;
			private String interval;
			private String ttl;

			public String getScript() {
				return script;
			}

			public void setScript(String script) {
				this.script = script;
			}

			public String getInterval() {
				return interval;
			}

			public void setInterval(String interval) {
				this.interval = interval;
			}

			public String getTtl() {
				return ttl;
			}

			public void setTtl(String ttl) {
				this.ttl = ttl;
			}

		}
	}
}
