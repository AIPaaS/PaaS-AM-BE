package com.ai.paas.cpaas.be.am.manage.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.ai.paas.cpaas.be.am.manage.RunJobThread;
import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.TaskStateType;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container.Check;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container.For;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppReq;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppResp;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppReq.HealthCheck;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppReq.Container.Docker;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppReq.Container.Volume;
import com.ai.paas.cpaas.be.am.manage.model.marathon.CreateAppReq.Container.Docker.PortMapping;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;

public class CreateLongRun extends RunJobThread<CreateAppReq> {

	protected CreateAppReq turnToMarathonReq(Container container) {
		CreateAppReq createAppReq = new CreateAppReq();
		createAppReq.setId(container.getContainerName());
		createAppReq.setCpus(container.getCpu());
		createAppReq.setMem(container.getMem());
		createAppReq.setInstances(container.getInstances());
		createAppReq.setRequirePorts(false);
		createAppReq.setMaxLaunchDelaySeconds(3);
		String depends = container.getDepends();
		if (StringUtils.isNotBlank(depends)) {
			createAppReq.setDependencies(Arrays.asList(depends.split(",", -1)));
		}
		CreateAppReq.Container appContainer = new CreateAppReq.Container();
		appContainer.setType("DOCKER");
		Docker docker = new Docker();
		docker.setImage(container.getImgFullName() + ":" + container.getImgVersion());
		docker.setNetwork("BRIDGE");
		if (CollectionUtils.isNotEmpty(container.getServicesFor())) {
			List<PortMapping> portMappings = new ArrayList<>();
			for (For sFor : container.getServicesFor()) {
				PortMapping portMapping = new PortMapping();
				portMapping.setServicePort(sFor.getPort());
				portMapping.setProtocol(sFor.getProtocol());
				portMapping.setHostPort(0);
				// portMapping.setContainerPort(6380);
				portMappings.add(portMapping);
			}
			docker.setPortMappings(portMappings);
		}
		docker.setPrivileged(false);
		appContainer.setDocker(docker);
		List<Volume> volumes = new ArrayList<>();
//		volumes.add(new Volume(container.getLogDir(), container.getDataDir(), "RW"));
		appContainer.setVolumes(volumes);
		createAppReq.setContainer(appContainer);

		// List<List<String>> constraints = new ArrayList<>();
		// constraints.add(Arrays.asList("zoneId", "CLUSTER",
		// container.getZoneId()));
		// if (CollectionUtils.isNotEmpty(container.getAttrs())) {
		// for (Parameter param : container.getAttrs())
		// constraints.add(Arrays.asList(param.getKey(), "CLUSTER",
		// param.getValue()));
		// }
		// createAppReq.setConstraints(constraints);

		List<HealthCheck> healthChecks = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(container.getHeathCheck())) {
			for (Check check : container.getHeathCheck()) {
				HealthCheck healthCheck = new HealthCheck();
				healthCheck.setPath(check.getCheckUrl());
				healthCheck.setProtocol(check.getProtocol());
				healthChecks.add(healthCheck);
			}
		}
		createAppReq.setHealthChecks(healthChecks);
		return createAppReq;
	}

	@Override
	protected boolean validate(Container container) {
		if (StringUtils.isBlank(container.getZoneId())) {
			int taskId = appTaskDetailService.saveAppTaskDetail(reqId, appId, container.getContainerName(), toJson(container), TaskStateType.FAIL);
			appTaskLogService.saveTaskLog(taskId, "start container " + container.getContainerName() + " failed because missing zoneId");
			return false;
		}
		return true;
	}

	@Override
	protected GeneralHttpResp runJob(String containerId, String param) throws RemoteServiceException {
		return remoteService.deployLongRun(param, CreateAppResp.class);
	}

}
