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

public class ConfigDO {
    //注意参数大小写
    private String Zk;
    private Integer ZkDetectionTimeout;
    private ArrayList<String> Masters;
    private Integer RefreshSeconds;
    private Integer StateTimeoutSeconds;
    private Integer TTL;
    private String Domain;
    private Integer Port;
    private ArrayList<String> Resolvers;
    private Integer Timeout;
    private String Listener;
    private Boolean   DnsOn;
    private Boolean   HttpOn;
    private Integer HttpPort;
    private Boolean   ExternalOn;
    private String SOAMname;
    private String SOARname;
    private Integer SOARefresh;
    private Integer SOARetry;
    private Integer SOAExpire;
    private Integer SOAMinttl;
    private Boolean  RecurseOn;
    private Boolean  EnforceRFC952;
    private ArrayList<String> IPSources;
    //配置文件路径
    private String File;
    //保留参数ID
    private String MID;

    public String getZk() {
        return Zk;
    }

    public void setZk(String zk) {
        Zk = zk;
    }

    public Integer getZkDetectionTimeout() {
        return ZkDetectionTimeout;
    }

    public void setZkDetectionTimeout(Integer zkDetectionTimeout) {
        ZkDetectionTimeout = zkDetectionTimeout;
    }

    public ArrayList<String> getMasters() {
        return Masters;
    }

    public void setMasters(ArrayList<String> masters) {
        Masters = masters;
    }

    public Integer getRefreshSeconds() {
        return RefreshSeconds;
    }

    public void setRefreshSeconds(Integer refreshSeconds) {
        RefreshSeconds = refreshSeconds;
    }

    public Integer getStateTimeoutSeconds() {
        return StateTimeoutSeconds;
    }

    public void setStateTimeoutSeconds(Integer stateTimeoutSeconds) {
        StateTimeoutSeconds = stateTimeoutSeconds;
    }

    public Integer getTTL() {
        return TTL;
    }

    public void setTTL(Integer TTL) {
        this.TTL = TTL;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public Integer getPort() {
        return Port;
    }

    public void setPort(Integer port) {
        Port = port;
    }

    public ArrayList<String> getResolvers() {
        return Resolvers;
    }

    public void setResolvers(ArrayList<String> resolvers) {
        Resolvers = resolvers;
    }

    public Integer getTimeout() {
        return Timeout;
    }

    public void setTimeout(Integer timeout) {
        Timeout = timeout;
    }

    public String getListener() {
        return Listener;
    }

    public void setListener(String listener) {
        Listener = listener;
    }

    public Boolean getDnsOn() {
        return DnsOn;
    }

    public void setDnsOn(Boolean dnsOn) {
        DnsOn = dnsOn;
    }

    public Boolean getHttpOn() {
        return HttpOn;
    }

    public void setHttpOn(Boolean httpOn) {
        HttpOn = httpOn;
    }

    public Integer getHttpPort() {
        return HttpPort;
    }

    public void setHttpPort(Integer httpPort) {
        HttpPort = httpPort;
    }

    public Boolean getExternalOn() {
        return ExternalOn;
    }

    public void setExternalOn(Boolean externalOn) {
        ExternalOn = externalOn;
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

    public Boolean getRecurseOn() {
        return RecurseOn;
    }

    public void setRecurseOn(Boolean recurseOn) {
        RecurseOn = recurseOn;
    }

    public Boolean getEnforceRFC952() {
        return EnforceRFC952;
    }

    public void setEnforceRFC952(Boolean enforceRFC952) {
        EnforceRFC952 = enforceRFC952;
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

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }
}
