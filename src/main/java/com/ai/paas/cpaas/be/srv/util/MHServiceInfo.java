package com.ai.paas.cpaas.be.srv.util;

import com.ai.paas.cpaas.be.srv.dao.interfaces.ResInstancePropsMapper;
import com.ai.paas.cpaas.be.srv.dao.mapper.bo.ResInstanceProps;
import com.ai.paas.cpaas.be.srv.dao.mapper.bo.ResInstancePropsCriteria;
import com.ai.paas.cpaas.be.srv.manage.model.HaproxyInfoDO;
import com.ai.paas.cpaas.be.srv.manage.model.MHInfoDO;
import com.ai.paas.ipaas.ServiceUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/15
 * AIC
 */
public class MHServiceInfo {

    public static final String MESOSDNS_HTTP = "mesosDNS";
    public static final String HAPROXY_INFO = "haproxy_info";
    public static final String KEEPALIVED_VIP = "keepalived_vip";


    public static MHInfoDO getMHInfo (String clusterId) {

        MHInfoDO mHInfoDO = new MHInfoDO();

        mHInfoDO.setMesosDnsUrl(getData(MESOSDNS_HTTP,clusterId));
        mHInfoDO.setKeepaliveIp(getData(KEEPALIVED_VIP,clusterId));
        String result = getData(HAPROXY_INFO,clusterId);
        Gson gson=new Gson();
        List<HaproxyInfoDO> haproxyInfoDOs = gson.fromJson(result, new TypeToken<List<HaproxyInfoDO>>(){}.getType());
        if (null != haproxyInfoDOs && haproxyInfoDOs.size() > 0){
            mHInfoDO.setHaProxyUser(haproxyInfoDOs.get(0).getUser());
            mHInfoDO.setHaProxyPw(haproxyInfoDOs.get(0).getPwd());
        }

        return mHInfoDO;
    }
    //返回keepaliveIP
    public static String getKeepalivedVip(String clusterId){
        return getData(KEEPALIVED_VIP,clusterId);
    }
    //返回一个Mesosdns访问地址
    public static String getMesosdnsHttp(String clusterId){
        return getData(MESOSDNS_HTTP,clusterId);
    }
    //返回haproxy ip port user pwd
    public static HaproxyInfoDO getHaproxyInfo(String clusterId){
        String result = getData(HAPROXY_INFO,clusterId);
        Gson gson=new Gson();
        List<HaproxyInfoDO> haproxyInfoDOs = gson.fromJson(result, new TypeToken<List<HaproxyInfoDO>>(){}.getType());
        if (null != haproxyInfoDOs && haproxyInfoDOs.size() > 0){
            return haproxyInfoDOs.get(0);
        }
        return null;
    }


    public static String getData(String key,String clusterId) {

        ResInstancePropsMapper im = ServiceUtil.getMapper(ResInstancePropsMapper.class);
        ResInstancePropsCriteria imc = new ResInstancePropsCriteria();
        imc.createCriteria().andKeyCodeEqualTo(key).andStateEqualTo(0).andClusterIdEqualTo(clusterId);
        imc.setLimitStart(0);
        imc.setLimitEnd(1);
        List<ResInstanceProps> list = im.selectByExample(imc);
        if (list != null && list.size() > 0)
            //TODO NULL
            return list.get(0).getKeyValue();
        return null;

    }




}
