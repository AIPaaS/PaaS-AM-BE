package com.ai.paas.cpaas.be.am.service;

import java.util.List;

import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.chronos.JobsResp;
import com.ai.paas.cpaas.be.am.manage.model.consul.ServiceInfo;

public interface IRemoteService {

	public <T extends GeneralHttpResp> T deployLongRun(String createAppReq, Class<T> cls) throws RemoteServiceException;

	public GeneralHttpResp deployTimer(String createAppReq) throws RemoteServiceException;

	public GeneralHttpResp deployTimerDependency(String createAppReq) throws RemoteServiceException;

	public <T extends GeneralHttpResp> T getContainerInfo(String containerId, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralHttpResp> T putConfig(String changeConfigReq, String containerId, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralHttpResp> T getConfig(String containerId, String version, Class<T> cls) throws RemoteServiceException;

	public <T extends GeneralHttpResp> T destroyLongRun(String containerId, Class<T> cls) throws RemoteServiceException;

	public GeneralHttpResp destroyTimer(String name) throws RemoteServiceException;

	public GeneralHttpResp forceTimer(String name) throws RemoteServiceException;
	
	public boolean timerJobExist(String name) throws RemoteServiceException;
	
	public JobsResp getTimerJobs() throws RemoteServiceException;

	public boolean registerService(String param) throws RemoteServiceException;

	public boolean deRegisterService(String param) throws RemoteServiceException;

	public List<ServiceInfo> getServiceInfo(String param) throws RemoteServiceException;
}
