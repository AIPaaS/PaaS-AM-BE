package com.ai.paas.cpaas.be.srv.manage.model.mesos;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * shaozhanpeng
 * 2016/3/7
 * AIC
 */


/**
 * mesos-dns/config.json
 * http://mesosphere.github.io/mesos-dns/docs/configuration-parameters.html
 */

public class configDO {
    private String zk;
    private Integer zkDetectionTimeout;
    private ArrayList<String> masters;
    private Integer refreshSeconds;
    private Integer stateTimeoutSeconds;
    private Integer ttl;
    private String domain;
    private Integer port;
    private ArrayList<String> resolvers;
    private Integer timeout;
    private String listener;
    private boolean  dnson;
    private boolean  httpon;
    private Integer httpport;
    private boolean  externalon;
    private String SOAMname;
    private String SOARname;
    private Integer SOARefresh;
    private Integer SOARetry;
    private Integer SOAExpire;
    private Integer SOAMinttl;
    private boolean recurseon;
    private boolean enforceRFC952;
    private ArrayList<String> IPSources;
    //配置文件路径
    private String File;

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public Integer getZkDetectionTimeout() {
        return zkDetectionTimeout;
    }

    public void setZkDetectionTimeout(Integer zkDetectionTimeout) {
        this.zkDetectionTimeout = zkDetectionTimeout;
    }

    public ArrayList<String> getMasters() {
        return masters;
    }

    public void setMasters(ArrayList<String> masters) {
        this.masters = masters;
    }

    public Integer getRefreshSeconds() {
        return refreshSeconds;
    }

    public void setRefreshSeconds(Integer refreshSeconds) {
        this.refreshSeconds = refreshSeconds;
    }

    public Integer getStateTimeoutSeconds() {
        return stateTimeoutSeconds;
    }

    public void setStateTimeoutSeconds(Integer stateTimeoutSeconds) {
        this.stateTimeoutSeconds = stateTimeoutSeconds;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public ArrayList<String> getResolvers() {
        return resolvers;
    }

    public void setResolvers(ArrayList<String> resolvers) {
        this.resolvers = resolvers;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public boolean isDnson() {
        return dnson;
    }

    public void setDnson(boolean dnson) {
        this.dnson = dnson;
    }

    public boolean isHttpon() {
        return httpon;
    }

    public void setHttpon(boolean httpon) {
        this.httpon = httpon;
    }

    public Integer getHttpport() {
        return httpport;
    }

    public void setHttpport(Integer httpport) {
        this.httpport = httpport;
    }

    public boolean isExternalon() {
        return externalon;
    }

    public void setExternalon(boolean externalon) {
        this.externalon = externalon;
    }

    public String getSOAMname() {
        return SOAMname;
    }

    public void setSOAMname(String SOAMname) {
        this.SOAMname = SOAMname;
    }

    public String getSOARname() {
        return SOARname;
    }

    public void setSOARname(String SOARname) {
        this.SOARname = SOARname;
    }

    public Integer getSOARefresh() {
        return SOARefresh;
    }

    public void setSOARefresh(Integer SOARefresh) {
        this.SOARefresh = SOARefresh;
    }

    public Integer getSOARetry() {
        return SOARetry;
    }

    public void setSOARetry(Integer SOARetry) {
        this.SOARetry = SOARetry;
    }

    public Integer getSOAExpire() {
        return SOAExpire;
    }

    public void setSOAExpire(Integer SOAExpire) {
        this.SOAExpire = SOAExpire;
    }

    public Integer getSOAMinttl() {
        return SOAMinttl;
    }

    public void setSOAMinttl(Integer SOAMinttl) {
        this.SOAMinttl = SOAMinttl;
    }

    public boolean isRecurseon() {
        return recurseon;
    }

    public void setRecurseon(boolean recurseon) {
        this.recurseon = recurseon;
    }

    public boolean isEnforceRFC952() {
        return enforceRFC952;
    }

    public void setEnforceRFC952(boolean enforceRFC952) {
        this.enforceRFC952 = enforceRFC952;
    }

    public ArrayList<String> getIPSources() {
        return IPSources;
    }

    public void setIPSources(ArrayList<String> IPSources) {
        this.IPSources = IPSources;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }
}
