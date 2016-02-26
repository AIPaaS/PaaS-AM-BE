package com.ai.paas.cpaas.be.am.service;

public interface ISystemCodesService {

	public String getCode(String sysCode, String codeKey) throws ConfigMissException;

}
