package com.ai.paas.cpaas.mgmt.service;

import java.util.List;

import com.ai.paas.cpaas.mgmt.manage.model.consul.ServiceInfo;
import com.ai.paas.cpaas.mgmt.manage.model.marathon.GeneralResp;

public interface IRemoteService {

	public <T extends GeneralResp> T deployLongRun(String createAppReq, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralResp> T getContainerInfo(String containerId, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralResp> T putConfig(String changeConfigReq, String containerId, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralResp> T getConfig(String containerId, String version, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralResp> T destroyLongRun(String containerId, Class<T> cls) throws RemoteServiceException;

	public boolean registerService(String param) throws RemoteServiceException;

	public boolean deRegisterService(String param) throws RemoteServiceException;

	public List<ServiceInfo> getServiceInfo(String param) throws RemoteServiceException;
}
