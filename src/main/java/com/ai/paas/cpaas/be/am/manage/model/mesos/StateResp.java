package com.ai.paas.cpaas.be.am.manage.model.mesos;

import java.util.List;

public class StateResp {
	private List<FrameWork> frameworks;

	public List<FrameWork> getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(List<FrameWork> frameworks) {
		this.frameworks = frameworks;
	}

	public static class FrameWork {
		private List<Executor> executors;

		public List<Executor> getExecutors() {
			return executors;
		}

		public void setExecutors(List<Executor> executors) {
			this.executors = executors;
		}

		public static class Executor {
			private String container;
			private String id;

			public String getContainer() {
				return container;
			}

			public void setContainer(String container) {
				this.container = container;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

		}
	}
}
