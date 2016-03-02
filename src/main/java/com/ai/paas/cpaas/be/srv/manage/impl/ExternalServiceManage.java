package com.ai.paas.cpaas.be.srv.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.ResClusterInfo;
import com.ai.paas.cpaas.be.am.service.IResClusterInfoService;
import com.ai.paas.cpaas.be.srv.interfaces.IExternalServiceManager;
import com.ai.paas.cpaas.be.srv.manage.model.ExternalQueryResp;
import com.ai.paas.cpaas.be.srv.manage.model.ExternalServiceReq;
import com.ai.paas.cpaas.be.srv.manage.model.ExternalServiceResp;
import com.ai.paas.cpaas.be.srv.manage.model.Parameter;
import com.ai.paas.cpaas.be.srv.manage.model.consul.RegisterReq;
import com.ai.paas.cpaas.be.srv.manage.model.consul.ServiceInfo;
import com.ai.paas.cpaas.be.srv.service.RemoteServiceException;
import com.ai.paas.cpaas.be.srv.service.remote.DirectRemoteService;
import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;

@Service
public class ExternalServiceManage implements IExternalServiceManager {
	private static Logger logger = Logger.getLogger(ExternalServiceManage.class);
	@Autowired
	private IResClusterInfoService resClusterInfoService;

	@Override
	public String add(String param) {
		return register(param);
	}

	@Override
	public String modify(String param) {
		return register(param);
	}

	private String register(String param) {
		Gson gson = new Gson();
		ExternalServiceResp externalServiceResp = gson.fromJson(param, ExternalServiceResp.class);
		ExternalServiceReq externalServiceReq = gson.fromJson(param, ExternalServiceReq.class);
		ResClusterInfo resClusterInfo = resClusterInfoService.getClusterInfo(externalServiceReq.getClusterId());
		DirectRemoteService clusterProxy = new DirectRemoteService(resClusterInfo);
		RegisterReq registerReq = new RegisterReq();
		registerReq.setAddress(externalServiceReq.getAddress());
		registerReq.setNode(externalServiceReq.getServiceId());
		RegisterReq.Service service = new RegisterReq.Service();
		service.setId(externalServiceReq.getServiceId());
		service.setService(externalServiceReq.getServiceName());
		service.setAddress(externalServiceReq.getAddress());
		service.setPort(externalServiceReq.getPort());

		if (CollectionUtils.isNotEmpty(externalServiceReq.getAttributes())) {
			List<String> tags = new ArrayList<>();
			for (Parameter parameter : externalServiceReq.getAttributes()) {
				tags.add(parameter.getKey() + ":" + parameter.getValue());
			}
			service.setTags(tags);
		}

		if (CollectionUtils.isNotEmpty(externalServiceReq.getCheck())) {
			List<RegisterReq.Service.Check> checks = new ArrayList<>();
			for (ExternalServiceReq.Check check : externalServiceReq.getCheck()) {
				RegisterReq.Service.Check serviceCheck = new RegisterReq.Service.Check();
				serviceCheck.setInterval(check.getInterval());
				serviceCheck.setScript(check.getScript());
				serviceCheck.setTtl(check.getTtl());
				checks.add(serviceCheck);
			}
			service.setChecks(checks);
		}

		registerReq.setService(service);
		try {
			clusterProxy.registerService(gson.toJson(registerReq));
		} catch (RemoteServiceException e) {
			logger.error(e);
			externalServiceResp.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			externalServiceResp.setResultMsg("register failed because exception");
		}
		return gson.toJson(externalServiceResp);
	}

	@Override
	public String delete(String param) {
		Gson gson = new Gson();
		ExternalServiceResp externalServiceResp = gson.fromJson(param, ExternalServiceResp.class);
		ExternalServiceReq externalServiceReq = gson.fromJson(param, ExternalServiceReq.class);
		ResClusterInfo resClusterInfo = resClusterInfoService.getClusterInfo(externalServiceReq.getClusterId());
		DirectRemoteService clusterProxy = new DirectRemoteService(resClusterInfo);

		RegisterReq registerReq = new RegisterReq();
		registerReq.setNode(externalServiceReq.getServiceId());
		registerReq.setServiceId(externalServiceReq.getServiceId());
		try {
			clusterProxy.deRegisterService(gson.toJson(registerReq));
		} catch (RemoteServiceException e) {
			logger.error(e);
			externalServiceResp.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			externalServiceResp.setResultMsg("deregister failed because exception");
		}
		return gson.toJson(externalServiceResp);
	}

	@Override
	public String query(String param) {
		Gson gson = new Gson();
		ExternalQueryResp externalQueryResp = gson.fromJson(param, ExternalQueryResp.class);
		ExternalServiceReq externalServiceReq = gson.fromJson(param, ExternalServiceReq.class);
		ResClusterInfo resClusterInfo = resClusterInfoService.getClusterInfo(externalServiceReq.getClusterId());
		DirectRemoteService clusterProxy = new DirectRemoteService(resClusterInfo);

		try {
			List<ServiceInfo> infos = clusterProxy.getServiceInfo(externalServiceReq.getServiceName());
			if (CollectionUtils.isNotEmpty(infos)) {
				for (ServiceInfo serviceInfo : infos) {
					if (externalServiceReq.getServiceId().equals(serviceInfo.getServiceId())) {
						externalQueryResp.setAddress(serviceInfo.getServiceAddress());
						externalQueryResp.setPort(serviceInfo.getServicePort());
						if (CollectionUtils.isNotEmpty(serviceInfo.getServiceTags())) {
							List<Parameter> attributes = new ArrayList<>();
							for (String str : serviceInfo.getServiceTags()) {
								String[] arr = str.split(":", -1);
								if (arr.length >= 2) {
									Parameter parameter = new Parameter(arr[0], arr[1]);
									attributes.add(parameter);
								}
							}
							externalQueryResp.setAttributes(attributes);
						}
						break;
					}
				}
			}
		} catch (RemoteServiceException e) {
			logger.error(e);
			externalQueryResp.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			externalQueryResp.setResultMsg("deregister failed because exception");
		}
		return gson.toJson(externalQueryResp);
	}

}
