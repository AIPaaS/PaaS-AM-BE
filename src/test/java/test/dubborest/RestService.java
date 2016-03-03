package test.dubborest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.cpaas.be.am.manage.model.ExternalServiceReq;
import com.ai.paas.cpaas.be.am.manage.model.ExternalServiceReq.Check;
import com.ai.paas.cpaas.be.srv.interfaces.IExternalServiceManager;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/consumer.xml" })
public class RestService {
	@Autowired
	private IExternalServiceManager externalServiceManager;
	@Reference
	private IExternalServiceManager iExternalServiceManager;
	
	@Test
	public void add() {
		ExternalServiceReq externalServiceReq = new ExternalServiceReq();
		externalServiceReq.setClusterId("dev");
		externalServiceReq.setServiceId("redis2");
		externalServiceReq.setServiceName("redis");
		externalServiceReq.setAddress("10.1.241.128");
		externalServiceReq.setPort(31553);
		List<Check> checks = new ArrayList<>();
		Check check = new Check();
		check.setScript("/bin/check_redis -p 7000");
		check.setInterval("30s");
		check.setTtl("60s");
		checks.add(check);
		externalServiceReq.setCheck(checks);
		String result= externalServiceManager.add((new Gson()).toJson(externalServiceReq));
		System.out.println(result);
	}
}
