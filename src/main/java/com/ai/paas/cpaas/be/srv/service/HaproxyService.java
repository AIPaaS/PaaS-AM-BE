package com.ai.paas.cpaas.be.srv.service;

import com.ai.paas.cpaas.be.srv.manage.model.haproxy.HaproxyCfgDO;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;

import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/9
 * AIC
 */
public interface HaproxyService {

    /**
     * 新增或更新 ACL  haproxy.cfg
     */
    public String addOrUpdate(String newServiceName,String oldServiceName,List<ServiceDO> serviceDOs,String editDate,String cluster,int mode);
    /**
     * 查询 ACL haproxy.cfg by appname
     */
    public String queryConfig(HaproxyCfgDO haproxyCfgDO);
    /**
     * 删除 ACL haproxy.cfg
     */
    public String delConfig(String serviceName,String editDate,String cluster);

    /**
     * 回滚 ACL haproxy.cfg
     */
    public String rollBack (String cluster);

}
