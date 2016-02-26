package com.ai.paas.cpaas.be.am.service;

import com.ai.paas.ipaas.PaasException;

public class RemoteServiceException extends PaasException {

	public RemoteServiceException(Exception ex) {
		this("", ex);
	}

	public RemoteServiceException(String errCode, Exception ex) {
		super(errCode, ex);
	}

	public RemoteServiceException(String errCode, String errDetail, Exception ex) {
		super(errCode, errDetail, ex);
	}

	public RemoteServiceException(String errCode, String errDetail) {
		super(errCode, errDetail);
	}

	public RemoteServiceException(String errDetail) {
		super(errDetail);
	}

}
