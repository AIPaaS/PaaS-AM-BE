package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.marathon.FailedResp;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ConfigDO;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.MesosService;
import com.ai.paas.cpaas.be.srv.service.RemoteServiceException;
import com.ai.paas.cpaas.be.srv.util.MHServiceInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String getVersion(String clusterId) {
        String tmpUrl = MHServiceInfo.getMesosdnsHttp(clusterId);
        String url  = mkMesosDnsURL(tmpUrl,MESOS_VERSION_PATH,"");
        String result = httpGet(url);
        return result;
    }

    @Override
    public String getConfig(String clusterId) {
        String tmpUrl = MHServiceInfo.getMesosdnsHttp(clusterId);
        String url  = mkMesosDnsURL(tmpUrl,MESOS_CONFIG_PATH,"");
        String result = httpGet(url);
        if (null == result) return null;
        return result;
    }

    @Override
    public String getHosts(String hostId,String clusterId) {
        String tmpUrl = MHServiceInfo.getMesosdnsHttp(clusterId);
        String url  = mkMesosDnsURL(tmpUrl,MESOS_HOST_PATH,hostId);
        String result = httpGet(url);
        return result;
    }

    @Override
    public List<ServiceDO> getServices(String serviceId,String clusterId) {
        String tmpUrl = MHServiceInfo.getMesosdnsHttp(clusterId);
        if (null == tmpUrl) {
            logger.warn("MesosService.getServices canot get mesosdns");
            return null;
        }
        String url = mkMesosDnsURL(tmpUrl,MESOS_SERVICE_PATH,serviceId);
        String result = httpGet(url);

        Gson gson=new Gson();
        List<ServiceDO> serviceDOs = gson.fromJson(result, new TypeToken<List<ServiceDO>>(){}.getType());
        if(null == serviceDOs) {
            logger.warn("MesosService.getServices serviceDOs is null");
            return null;
        }

        for (ServiceDO tmp:serviceDOs){
            if (null == tmp.getIp() || null == tmp.getPort()) {
                logger.warn("MesosService.getServices httpget is null");
                return null;
            }
        }

        //TODO check List
        for (ServiceDO tmp:serviceDOs){
            if (null ==tmp.getIp()) {
                logger.warn("MesosService.getServices some service IP canot get");
                return null;
            }
        }
        return serviceDOs;
    }

    public static String mkMesosDnsURL (String url,String param,String id){
        return url + param + id;
    }


}
