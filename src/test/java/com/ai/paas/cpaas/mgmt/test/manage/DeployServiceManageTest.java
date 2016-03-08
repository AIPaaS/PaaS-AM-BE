package com.ai.paas.cpaas.mgmt.test.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.ai.paas.cpaas.be.am.manage.model.GeneralReq;
import com.ai.paas.cpaas.be.am.manage.model.LogReq;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container;
import com.ai.paas.cpaas.be.am.manage.model.GeneralReq.Container.For;
import com.google.gson.Gson;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:dubbo/consumer/mgmt-client-consumer.xml", "classpath:dubbo/consumer/applicationContext-mybatis.xml" })
public class DeployServiceManageTest {
	//
	// @Autowired
	// private IDeployServiceManager deployServiceManager;

	@Test
	public void createLongRun() throws ParseException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/create/longrun");

		GeneralReq createReq = new GeneralReq();
		createReq.setClusterId("99");
		createReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		container.setImgFullName("redis");
		container.setImgVersion("3.0.5");
		container.setCpu(1d);
		container.setMem(512);
		container.setInstances(1);
		container.setZoneId("backend");
		container.setLogDir("/var/log/");
		container.setDataDir("/data");
		List<For> servicesFor = new ArrayList<>();
		For fo = new For();
		fo.setPort(10005);
		fo.setProtocol("tcp");
		servicesFor.add(fo);
		container.setServicesFor(servicesFor);
		containers.add(container);
		createReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(createReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void scale() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/scale");

		GeneralReq scaleReq = new GeneralReq();
		scaleReq.setClusterId("dev");
		scaleReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		container.setInstances(2);
		containers.add(container);
		scaleReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(scaleReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void start() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/start");

		GeneralReq scaleReq = new GeneralReq();
		scaleReq.setClusterId("dev");
		scaleReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		container.setInstances(1);
		containers.add(container);
		scaleReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(scaleReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void upgrade() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/upgrade");

		GeneralReq scaleReq = new GeneralReq();
		scaleReq.setClusterId("dev");
		scaleReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setVersion("2016-02-18T06:40:25.930Z");
		container.setContainerName("test-redis-1");
		container.setImgFullName("redis");
		container.setImgVersion("3.0.6");
		containers.add(container);
		scaleReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(scaleReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void stop() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/stop");

		GeneralReq scaleReq = new GeneralReq();
		scaleReq.setClusterId("dev");
		scaleReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		containers.add(container);
		scaleReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(scaleReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void destroyLongRun() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/destroy/longrun");

		GeneralReq scaleReq = new GeneralReq();
		scaleReq.setClusterId("dev");
		scaleReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		containers.add(container);
		scaleReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(scaleReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void log() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/log");
		LogReq logReq = new LogReq();
		logReq.setReqId(50);

		StringEntity entity = new StringEntity((new Gson()).toJson(logReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void status() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/status");

		GeneralReq generalReq = new GeneralReq();
		generalReq.setClusterId("dev");
		generalReq.setAppId("runner-test");
		List<Container> containers = new ArrayList<>();
		Container container = new Container();
		container.setContainerName("test-redis-1");
		containers.add(container);
		generalReq.setContainers(containers);
		StringEntity entity = new StringEntity((new Gson()).toJson(generalReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}
}
