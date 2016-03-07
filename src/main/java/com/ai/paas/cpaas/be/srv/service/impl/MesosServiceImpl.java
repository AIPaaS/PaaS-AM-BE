package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.marathon.FailedResp;
import com.ai.paas.cpaas.be.srv.service.MesosService;
import com.ai.paas.cpaas.be.srv.service.RemoteServiceException;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * shaozhanpeng
 * 2016/3/7
 * AIC
 */
public class MesosServiceImpl implements MesosService {

    private static Logger logger = Logger.getLogger(MesosServiceImpl.class);
    public static final String MESOS_CONFIG_PATH = "/v1/config";

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public String getConfig() {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://10.1.241.124:8123/v1/config");
            CloseableHttpResponse resp = httpclient.execute(httpPost);
            HttpEntity respEntity = resp.getEntity();
            String respString = EntityUtils.toString(respEntity, "UTF-8");

            return respString;
            } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getHosts(String hostName) {
        return null;
    }

    @Override
    public String getServices(String serviceName) {
        return null;
    }
}
