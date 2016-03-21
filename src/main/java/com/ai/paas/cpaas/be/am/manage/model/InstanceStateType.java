package com.ai.paas.cpaas.be.am.manage.model;

public enum InstanceStateType {
	RUNNING(1, "RUNNING"), STAGING(2, "STAGING"), FAILED(3, "FAILED");

	private int key;
	private String name;

	private InstanceStateType(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public static String valueOf(int key) {
		for (InstanceStateType instanceStateType : InstanceStateType.values()) {
			if (instanceStateType.getKey() == key)
				return instanceStateType.getName();
		}
		return null;
	}

	public static int keyOf(String value) {
		for (InstanceStateType instanceStateType : InstanceStateType.values()) {
			if (instanceStateType.getName().equals(value))
				return instanceStateType.getKey();
		}
		return -1;
	}
}
