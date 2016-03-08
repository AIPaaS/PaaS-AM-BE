package com.ai.paas.cpaas.mgmt.test.manage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.cpaas.be.am.interfaces.IDeployServiceManager;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/consumer.xml" })
public class DeployTest {
	@Autowired
	IDeployServiceManager deployServiceManager;

	@Test
	public void createLongRun() {
		GeneralReq createReq = new GeneralReq();
		createReq.setClusterId("99");
		createReq.setDataCenterId("74");
		createReq.setAppId("82");
		createReq.setAppName("runner-test");
		createReq.setAppNameCN("客户管理");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test");
		container.setImgFullName("redis");
		container.setImgVersion("3.0.6");
		container.setCpu(1d);
		container.setMem(512);
		container.setInstances(1);
		container.setZoneId("backend");
		container.setLogDir("/var/log/");
		container.setDataDir("/data");

		containers.add(container);
		createReq.setContainers(containers);

		String resp = deployServiceManager.createLongRun((new Gson()).toJson(createReq));
		System.out.println(resp);
	}
}
