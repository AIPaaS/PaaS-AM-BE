package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.HaproxyService;
import com.ai.paas.cpaas.be.srv.service.MHService;
import com.ai.paas.cpaas.be.srv.service.MesosService;
import com.ai.paas.cpaas.be.srv.util.MHServiceInfo;
import com.ai.paas.cpaas.be.srv.vo.HaproxyResultVo;
import com.ai.paas.cpaas.be.srv.vo.TransResultVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String addOrUpdateAcl(String dns,String container,String newServiceName, String oldServiceName,String clusterId,int mode) {
        String editDate = getDate();
        List<ServiceDO> result = mesosService.getServices(dns,clusterId);

        if (null == result) return null;
        String tf =  haproxyService.addOrUpdate(newServiceName,oldServiceName,result,editDate,clusterId,mode);
        if (null == tf) return null;

        Gson gson = new Gson();
        TransResultVo resultVo = gson.fromJson(tf, TransResultVo.class);

        HaproxyResultVo haproxyResultVo = new HaproxyResultVo();

        if (null == resultVo.getCode()){
            haproxyResultVo.setCode("1");
        }else {
            haproxyResultVo.setCode(resultVo.getCode());
        }
        haproxyResultVo.setMsg(resultVo.getMsg());
        haproxyResultVo.setAccessUrl(mkAccessUrl(clusterId,newServiceName));

        Gson gsonre = new Gson();
        String response = gsonre.toJson(haproxyResultVo);

//        if (!tf) haproxyService.rollBack(clusterId);
        //TODO if rollback fail
        return response;
    }

    @Override
    public String delAcl(String oldServiceName,String clusterId) {
        String editDate = getDate();
        String tf = haproxyService.delConfig(oldServiceName,editDate,clusterId);

        Gson gson = new Gson();
        TransResultVo resultVo = gson.fromJson(tf, TransResultVo.class);

        HaproxyResultVo haproxyResultVo = new HaproxyResultVo();

        if (null == resultVo.getCode()){
            haproxyResultVo.setCode("1");
        }else {
            haproxyResultVo.setCode(resultVo.getCode());
        }
        haproxyResultVo.setMsg(resultVo.getMsg());
        haproxyResultVo.setAccessUrl(mkAccessUrl(clusterId,oldServiceName));

        Gson gsonre = new Gson();
        String response = gsonre.toJson(haproxyResultVo);

//        if(!tf) haproxyService.rollBack(clusterId);
        //TODO if rollback fail
        return response;
    }

    @Override
    public String quryHaproxyCfg() {
        return null;
    }

    @Override
    public String quryKeepAliveVIP(String clusterId) {
        String result = MHServiceInfo.getKeepalivedVip(clusterId);
        if (null == result ) return null;
        HaproxyResultVo haproxyResultVo = new HaproxyResultVo();
        haproxyResultVo.setCode("0");
        haproxyResultVo.setMsg("success");
        haproxyResultVo.setAccessUrl(result);

        Gson gsonre = new Gson();
        String response = gsonre.toJson(haproxyResultVo);

        return  response;
    }

    //时间戳
    public static String getDate () {
        Format format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }

    public static String mkAccessUrl(String clusterId,String serverName){
        String tmp = MHServiceInfo.getKeepalivedVip(clusterId);
        String result = "http://" + tmp + "/" + serverName;
    return result;
    }


}
