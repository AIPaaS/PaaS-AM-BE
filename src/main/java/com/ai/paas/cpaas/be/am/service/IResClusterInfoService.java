package com.ai.paas.cpaas.be.am.service;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.ResClusterInfo;

public interface IResClusterInfoService {
	
	public ResClusterInfo getClusterInfo(String clusterId);
}
