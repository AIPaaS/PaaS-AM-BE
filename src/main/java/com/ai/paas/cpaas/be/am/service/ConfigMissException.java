package com.ai.paas.cpaas.be.am.service;

import com.ai.paas.ipaas.PaasException;

public class ConfigMissException extends PaasException {

	public ConfigMissException(String errCode, Exception ex) {
		super(errCode, ex);
	}

	public ConfigMissException(String errCode, String errDetail, Exception ex) {
		super(errCode, errDetail, ex);
	}

	public ConfigMissException(String errCode, String errDetail) {
		super(errCode, errDetail);
	}

	public ConfigMissException(String errDetail) {
		super(errDetail);
	}

}
