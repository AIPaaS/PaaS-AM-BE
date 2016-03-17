package com.ai.paas.cpaas.be.am.manage.model;

public class EnvironmentVariable {
	private String name;
	private String value;

	public EnvironmentVariable() {

	}

	public EnvironmentVariable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
