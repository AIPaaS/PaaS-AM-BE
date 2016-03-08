package com.ai.paas.cpaas.be.srv.manage.model.mesos;

/**
 * shaozhanpeng
 * 2016/3/8
 * AIC
 */
public class VersionDO {
    private String Service;
    private String URL;
    private String Version;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
