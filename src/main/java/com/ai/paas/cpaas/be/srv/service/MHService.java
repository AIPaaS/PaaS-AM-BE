package com.ai.paas.cpaas.be.srv.service;

/**
 * shaozhanpeng
 * 2016/3/14
 * AIC
 * MesosService HaproxyService 对外服务接口
 */
public interface MHService {
    /**
     * 新增、更新Haproxy.cfg
     * @param newServiceName 新增
     * @param oldServiceName 需删除
     */
    public boolean addOrUpdateAcl(String newServiceName,String oldServiceName,String clusterId );

    /**
     * 删除 Haproxy.cfg ACL
     */
    public boolean delAcl(String oldServiceName,String clusterId );


    /**
     * 查询 Haproxy.cfg
     */
    public String quryHaproxyCfg();

    /**
     * 获取 keepaliveVIP
     */
    public String quryKeepAliveVIP(String clusterId);

}
