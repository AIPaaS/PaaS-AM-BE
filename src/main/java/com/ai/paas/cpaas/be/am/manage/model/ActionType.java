package com.ai.paas.cpaas.be.am.manage.model;

public enum ActionType {
	deploy(1, "deploy"), start(2, "start"), stop(3, "stop"), upgrade(4, "upgrade"), scale(5, "scale"), destroy(6, "destroy");

	private int value;
	private String name;

	private ActionType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static String valueOf(int value) {
		for (ActionType actionType : ActionType.values()) {
			if (value == actionType.getValue()) {
				return actionType.getName();
			}
		}
		return null;
	}
}
