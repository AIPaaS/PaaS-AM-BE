package com.ai.paas.cpaas.be.srv.manage.model.haproxy;

import java.util.Map;

/**
 * shaozhanpeng
 * 2016/3/10
 * AIC
 */
public class HaproxyCfgDO {
    //mesos-dns service
    private String appname;
    //key mesos-dns host，value mesos-dns ip：port
    private Map<String,String> serverMap;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Map<String, String> getServerMap() {
        return serverMap;
    }

    public void setServerMap(Map<String, String> serverMap) {
        this.serverMap = serverMap;
    }
}
