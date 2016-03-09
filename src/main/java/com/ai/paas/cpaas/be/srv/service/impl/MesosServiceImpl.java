package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.marathon.FailedResp;
import com.ai.paas.cpaas.be.srv.service.MesosService;
import com.ai.paas.cpaas.be.srv.service.RemoteServiceException;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.ai.paas.cpaas.be.srv.util.HttpRequestUtils.httpGet;

/**
 * shaozhanpeng
 * 2016/3/7
 * AIC
 */
@Service
public class MesosServiceImpl implements MesosService {

    private static Logger logger = Logger.getLogger(MesosServiceImpl.class);
    public static final String MESOS_CONFIG_PATH = "/v1/config";
    public static final String MESOS_VERSION_PATH = "/v1/version";
    public static final String MESOS_HOST_PATH = "/v1/hosts/";
    public static final String MESOS_SERVICE_PATH = "/v1/services/";


    //test
    public static final String ip = "10.1.241.124";
    public static final String port = "8123";
    public static final String serviceid = "_test._tcp.marathon.ai";
    public static final String hostid = "test.marathon.ai";


    @Override
    public String getVersion() {
        String url  = splitURL(ip,port,MESOS_VERSION_PATH,null);
        String result = httpGet(url);
        return result;
    }

    @Override
    public String getConfig() {
        String url  = splitURL(ip,port,MESOS_CONFIG_PATH,null);
        String result = httpGet(url);
        return result;
    }

    @Override
    public String getHosts(String hostName) {
        String url  = splitURL(ip,port,MESOS_HOST_PATH,hostid);
        String result = httpGet(url);
        return result;
    }

    @Override
    public String getServices(String serviceName) {
        String url  = splitURL(ip,port,MESOS_SERVICE_PATH,serviceid);
        String result = httpGet(url);
        return result;
    }


    public static String splitURL (String ip,String port,String param,String id){
            return "http://" + ip + ":" +  port + param + id;
    }



}
