package com.ai.paas.cpaas.be.am.manage.model.marathon;

import java.util.List;

import com.google.gson.Gson;

public class ChangeConfigReq {
	private String cmd;
	private List<List<String>> constraints;
	private String cpus;
	private Integer instances;
	private String mem;
	private Container container;

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public static class Container {
		private Docker docker;
//		private String type = "DOCKER";

		public Docker getDocker() {
			return docker;
		}

		public void setDocker(Docker docker) {
			this.docker = docker;
		}

		public static class Docker {
			private String image;

			public String getImage() {
				return image;
			}

			public void setImage(String image) {
				this.image = image;
			}

		}
	}

	public String toJson() {
		return (new Gson()).toJson(this);
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public List<List<String>> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<List<String>> constraints) {
		this.constraints = constraints;
	}

	public String getCpus() {
		return cpus;
	}

	public void setCpus(String cpus) {
		this.cpus = cpus;
	}

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

}
