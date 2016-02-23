package com.ai.paas.cpaas.mgmt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.cpaas.mgmt.dao.interfaces.ResClusterInfoMapper;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfo;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfoCriteria;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfoCriteria.Criteria;
import com.ai.paas.cpaas.mgmt.service.IResClusterInfoService;
import com.ai.paas.ipaas.ServiceUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResClusterInfoServiceImpl implements IResClusterInfoService {

	@Override
	public ResClusterInfo getClusterInfo(String clusterId) {
		ResClusterInfoMapper mapper = ServiceUtil.getMapper(ResClusterInfoMapper.class);
		ResClusterInfoCriteria resClusterInfoCriteria = new ResClusterInfoCriteria();
		Criteria criteria = resClusterInfoCriteria.createCriteria();
		criteria.andClusterNameEqualTo(clusterId);
		return mapper.selectByExample(resClusterInfoCriteria).get(0);
	}

}
