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

import com.ai.paas.cpaas.mgmt.manage.model.ExternalServiceReq;
import com.ai.paas.cpaas.mgmt.manage.model.ExternalServiceReq.Check;
import com.google.gson.Gson;

public class ExternalServiceManageTest {

	@Test
	public void add() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/external/manage/add");
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId("dev");
		externalServiceReq.setServiceId("redis1");
		externalServiceReq.setServiceName("redis");
		externalServiceReq.setAddress("10.1.241.126");
		externalServiceReq.setPort(31553);
		List<Check> checks = new ArrayList<>();
		Check check = new Check();
		check.setScript("/bin/check_redis -p 7000");
		check.setInterval("30s");
		check.setTtl("60s");
		checks.add(check);
		externalServiceReq.setCheck(checks);

		StringEntity entity = new StringEntity((new Gson()).toJson(externalServiceReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void delete() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/external/manage/delete");
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId("dev");
		externalServiceReq.setServiceId("redis1");
		StringEntity entity = new StringEntity((new Gson()).toJson(externalServiceReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}

	@Test
	public void query() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:20880/cpaas/external/manage/query");

		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId("dev");
		externalServiceReq.setServiceId("redis1");
		externalServiceReq.setServiceName("redis");
		StringEntity entity = new StringEntity((new Gson()).toJson(externalServiceReq), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);

		CloseableHttpResponse resp = httpclient.execute(httpPost);
		HttpEntity respEntity = resp.getEntity();
		String respString = EntityUtils.toString(respEntity, "UTF-8");
		System.out.println(respString);
	}
}
