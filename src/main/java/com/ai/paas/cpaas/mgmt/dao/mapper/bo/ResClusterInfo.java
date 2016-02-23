package com.ai.paas.cpaas.mgmt.dao.mapper.bo;

public class ResClusterInfo {
    private String clusterId;

    private String clusterName;

    private String marathonAddr;

    private String consulAddr;

    private String chronosAddr;

    private String mesosDomain;

    private String externalDomain;

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId == null ? null : clusterId.trim();
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName == null ? null : clusterName.trim();
    }

    public String getMarathonAddr() {
        return marathonAddr;
    }

    public void setMarathonAddr(String marathonAddr) {
        this.marathonAddr = marathonAddr == null ? null : marathonAddr.trim();
    }

    public String getConsulAddr() {
        return consulAddr;
    }

    public void setConsulAddr(String consulAddr) {
        this.consulAddr = consulAddr == null ? null : consulAddr.trim();
    }

    public String getChronosAddr() {
        return chronosAddr;
    }

    public void setChronosAddr(String chronosAddr) {
        this.chronosAddr = chronosAddr == null ? null : chronosAddr.trim();
    }

    public String getMesosDomain() {
        return mesosDomain;
    }

    public void setMesosDomain(String mesosDomain) {
        this.mesosDomain = mesosDomain == null ? null : mesosDomain.trim();
    }

    public String getExternalDomain() {
        return externalDomain;
    }

    public void setExternalDomain(String externalDomain) {
        this.externalDomain = externalDomain == null ? null : externalDomain.trim();
    }
}