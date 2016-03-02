package com.ai.paas.cpaas.be.srv.manage.model;

import java.util.List;

public class ExternalQueryResp extends GeneralExternalResp {
	private String address;
	private Integer port;
	private List<Parameter> attributes;

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

	public List<Parameter> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Parameter> attributes) {
		this.attributes = attributes;
	}

}
