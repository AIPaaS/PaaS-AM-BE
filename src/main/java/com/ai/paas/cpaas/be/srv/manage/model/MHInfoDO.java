package com.ai.paas.cpaas.be.srv.manage.model;

/**
 * shaozhanpeng
 * 2016/3/15
 * AIC
 */
public class MHInfoDO {
    //集群编号
    private String cluster;
    //某一台mesosDns访问地址   http://ip:port
    private String mesosDnsUrl;
    //haProxy登录账户（多台账户密码需保持一致）
    private String haProxyUser;
    //haProxy登录密码
    private String haProxyPw;
    //keepaliveIp地址
    private String keepaliveIp;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getMesosDnsUrl() {
        return mesosDnsUrl;
    }

    public void setMesosDnsUrl(String mesosDnsUrl) {
        this.mesosDnsUrl = mesosDnsUrl;
    }

    public String getHaProxyUser() {
        return haProxyUser;
    }

    public void setHaProxyUser(String haProxyUser) {
        this.haProxyUser = haProxyUser;
    }

    public String getHaProxyPw() {
        return haProxyPw;
    }

    public void setHaProxyPw(String haProxyPw) {
        this.haProxyPw = haProxyPw;
    }

    public String getKeepaliveIp() {
        return keepaliveIp;
    }

    public void setKeepaliveIp(String keepaliveIp) {
        this.keepaliveIp = keepaliveIp;
    }
}
