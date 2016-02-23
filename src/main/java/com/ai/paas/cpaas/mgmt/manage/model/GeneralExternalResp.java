package com.ai.paas.cpaas.mgmt.manage.model;

import com.ai.paas.ipaas.rest.vo.BaseResult;

public class GeneralExternalResp extends BaseResult {
	private String serviceId;
	private String serviceName;
	private String dataCenterId;
	private String dataCenter;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(String dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public String getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(String dataCenter) {
		this.dataCenter = dataCenter;
	}

}
