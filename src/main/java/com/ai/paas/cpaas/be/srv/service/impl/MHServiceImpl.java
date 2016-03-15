package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.HaproxyService;
import com.ai.paas.cpaas.be.srv.service.MHService;
import com.ai.paas.cpaas.be.srv.service.MesosService;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/14
 * AIC
 */
@Service
public class MHServiceImpl implements MHService {

    @Autowired
    private MesosService mesosService;
    @Autowired
    private HaproxyService haproxyService;

    @Override
    public boolean addOrUpdateAcl(String newServiceName, String oldServiceName) {
        String editDate = getDate();
        List<ServiceDO> result = mesosService.getServices(newServiceName);

        if (null == result) return false;
        boolean tf =  haproxyService.addOrUpdate(newServiceName,oldServiceName,result,editDate);
        //rollback
        if (!tf) haproxyService.rollBack();
        //TODO if rollback fail
        return tf;
    }

    @Override
    public boolean delAcl(String oldServiceName) {
        String editDate = getDate();
        boolean tf = haproxyService.delConfig(oldServiceName,editDate);
        if(!tf) haproxyService.rollBack();
        //TODO if rollback fail
        return tf;
    }

    @Override
    public String quryHaproxyCfg() {
        return null;
    }

    //时间戳
    public static String getDate () {
        Format format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }

}
