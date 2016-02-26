package com.ai.paas.cpaas.be.am.manage;

import com.ai.paas.ipaas.PaasException;

public class RequestParamException extends PaasException {

	public RequestParamException(String errCode, Exception ex) {
		super(errCode, ex);
	}

	public RequestParamException(String errCode, String errDetail, Exception ex) {
		super(errCode, errDetail, ex);
	}

	public RequestParamException(String errCode, String errDetail) {
		super(errCode, errDetail);
	}

	public RequestParamException(String errDetail) {
		super(errDetail);
	}

}
