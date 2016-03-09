package com.ai.paas.cpaas.be.srv.manage.model.mesos;

/**
 * shaozhanpeng
 * 2016/3/8
 * AIC
 */
public class ServiceDO {
    private String service;
    private String host;
    private String ip;
    private String port;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
