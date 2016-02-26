package com.ai.paas.cpaas.mgmt.test.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.ai.paas.cpaas.be.am.manage.model.GeneralTimerReq;
import com.ai.paas.cpaas.be.am.manage.model.Parameter;
import com.google.gson.Gson;

public class TimerServiceManageTest {

	@Test
	public void createTimer() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/create/timer");

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setClusterId("dev");
		generalTimerReq.setRetries(2);
		generalTimerReq.setStart("20160223231500");
		generalTimerReq.setRepeatNum("10");
		generalTimerReq.setPeriod("T2S");
		GeneralTimerReq.Container container = new GeneralTimerReq.Container();
		container.setContainerId("12345678");
		container.setContainerName("redis-chronos");
		container.setZoneId("backend");
		container.setAttrs("disk:ssd;netband:1G");
		container.setImgFullName("redis");
		container.setImgVersion("3.0.5");
		container.setCpu("2.0");
		container.setMem("512");
		container.setDisk("512");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter("a", "b"));
		container.setEnvVars(params);
		generalTimerReq.setContainer(container);

		StringEntity entity = new StringEntity((new Gson()).toJson(generalTimerReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void destroyTimer() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/destroy/timer");

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setClusterId("dev");

		StringEntity entity = new StringEntity((new Gson()).toJson(generalTimerReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void startTimer() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/start/timer");

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setClusterId("dev");

		StringEntity entity = new StringEntity((new Gson()).toJson(generalTimerReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void upgradeTimer() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/upgrade/timer");

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setClusterId("dev");

		StringEntity entity = new StringEntity((new Gson()).toJson(generalTimerReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void statusTimer() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/deploy/manage/status/timer");

		GeneralTimerReq generalTimerReq = new GeneralTimerReq();
		generalTimerReq.setClusterId("dev");

		StringEntity entity = new StringEntity((new Gson()).toJson(generalTimerReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}
}
