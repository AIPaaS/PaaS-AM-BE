package com.ai.paas.cpaas.mgmt.service;

import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfo;

public interface IResClusterInfoService {
	
	public ResClusterInfo getClusterInfo(String clusterId);
}
