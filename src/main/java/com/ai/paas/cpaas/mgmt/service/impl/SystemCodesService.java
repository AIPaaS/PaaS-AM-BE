package com.ai.paas.cpaas.mgmt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.cpaas.mgmt.dao.interfaces.SysCodesMapper;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.SysCodes;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.SysCodesCriteria;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.SysCodesCriteria.Criteria;
import com.ai.paas.cpaas.mgmt.service.ConfigMissException;
import com.ai.paas.cpaas.mgmt.service.ISystemCodesService;

@Service
@Transactional(rollbackFor = Exception.class)
public class SystemCodesService implements ISystemCodesService,InitializingBean {
	@Autowired
	private SqlSessionTemplate template; 
	private Map<String, Map<String, String>> sysCodesMap = new HashMap<>();


	@Override
	public void afterPropertiesSet() throws Exception {
		SysCodesMapper mapper = template.getMapper(SysCodesMapper.class);
		SysCodesCriteria sysCodesCriteria = new SysCodesCriteria();
		Criteria criteria = sysCodesCriteria.createCriteria();
		criteria.andCodeStateEqualTo(0);
		List<SysCodes> list = mapper.selectByExample(sysCodesCriteria);
		if (CollectionUtils.isNotEmpty(list)) {
			for (SysCodes sysCodes : list) {
				Map<String, String> codeMap = sysCodesMap.get(sysCodes.getSysCode());
				if (MapUtils.isEmpty(codeMap)) {
					codeMap = new HashMap<>();
					sysCodesMap.put(sysCodes.getSysCode(), codeMap);
				}
				codeMap.put(sysCodes.getCodeKey(), sysCodes.getCodeValue());
			}
		}
	}
	
	@Override
	public String getCode(String sysCode, String codeKey) throws ConfigMissException {
		Map<String, String> codeMap = sysCodesMap.get(sysCode);
		if (codeMap == null)
			throw new ConfigMissException("config sys code " + sysCode + " missing");
		else {
			String value = codeMap.get(codeKey);
			if (value == null)
				throw new ConfigMissException("config sys code " + sysCode + " , code key " + codeKey + " missing");
			else
				return value;
		}
	}


}
