package com.ai.paas.cpaas.be.am.manage.model;

import java.util.List;

import com.ai.paas.cpaas.be.am.manage.model.marathon.GetAppResp;
import com.ai.paas.ipaas.rest.vo.BaseResult;

public class StatusResp extends BaseResult{
	private List<GetAppResp> status;

	public List<GetAppResp> getStatus() {
		return status;
	}

	public void setStatus(List<GetAppResp> status) {
		this.status = status;
	}

}
