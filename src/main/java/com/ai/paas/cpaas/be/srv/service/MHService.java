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
    public boolean addOrUpdateAcl(String newServiceName,String oldServiceName );

    /**
     * 删除 Haproxy.cfg ACL
     */
    public boolean delAcl(String oldServiceName );

    /**
     * 查询 Haproxy.cfg
     * 待实现
     */
    public String quryHaproxyCfg();

}
