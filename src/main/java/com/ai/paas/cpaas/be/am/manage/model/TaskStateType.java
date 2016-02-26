package com.ai.paas.cpaas.be.am.manage.model;

public enum TaskStateType {
	STAGING(1, "STAGING"), SUCCESS(2, "SUCCESS"), FAIL(3, "FAIL");

	private int key;
	private String name;

	private TaskStateType(int key, String name) {
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
		for (TaskStateType taskStateType : TaskStateType.values()) {
			if (taskStateType.getKey() == key)
				return taskStateType.getName();
		}
		return null;
	}
}
