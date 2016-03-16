package com.ai.paas.cpaas.be.srv.util;


import com.ai.paas.cpaas.be.srv.manage.model.mesos.ConfigDO;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * shaozhanpeng
 * 2016/3/8
 * AIC
 */
public class HttpRequestUtils {
    private static Logger logger = Logger.getLogger(HttpRequestUtils.class);

    /**
     * post请求
     * @param url    url地址
     * @param param  参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static String httpPost(String url,String param, boolean noNeedResponse){


        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse resp = httpclient.execute(httpPost);
            HttpEntity respEntity = resp.getEntity();
            String respString = EntityUtils.toString(respEntity, "UTF-8");
            return respString;
        } catch (Exception e) {
            logger.error("HttpPost Exception");
            return null;
            }
        }


    /**
     * 发送get请求
     * @param url    地址
     * @return
     */
    public static String httpGet(String url){

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse resp = httpclient.execute(httpGet);
            HttpEntity respEntity = resp.getEntity();
            String respString = EntityUtils.toString(respEntity, "UTF-8");

            return respString;
        } catch (Exception e) {
            logger.error("HttpGet Exception:" + url);
            return null;
        }finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
