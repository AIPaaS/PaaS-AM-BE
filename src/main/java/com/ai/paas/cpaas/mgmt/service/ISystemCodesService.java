package com.ai.paas.cpaas.mgmt.service;

public interface ISystemCodesService {

	public String getCode(String sysCode, String codeKey) throws ConfigMissException;

}
