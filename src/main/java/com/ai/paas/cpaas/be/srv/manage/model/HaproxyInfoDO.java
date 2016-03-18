package com.ai.paas.cpaas.be.srv.manage.model;

import com.ai.paas.ipaas.util.CiperUtil;

/**
 * shaozhanpeng
 * 2016/3/15
 * AIC
 */
public class HaproxyInfoDO {
    private String ip;
    private String port;
    private String user;
    private String pwd;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
