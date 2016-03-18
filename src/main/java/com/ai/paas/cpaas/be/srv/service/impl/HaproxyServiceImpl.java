package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.AddOrUpdateHaproxyCfg;
import com.ai.paas.cpaas.be.srv.AnsibleHostsConfig;
import com.ai.paas.cpaas.be.srv.DelAclHaproxyCfg;
import com.ai.paas.cpaas.be.srv.RollBackHaproxyCfg;
import com.ai.paas.cpaas.be.srv.manage.model.HaproxyInfoDO;
import com.ai.paas.cpaas.be.srv.manage.model.haproxy.HaproxyCfgDO;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.HaproxyService;
import com.ai.paas.cpaas.be.srv.util.MHServiceInfo;
import com.ai.paas.ipaas.util.CiperUtil;
import org.apache.log4j.Logger;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ai.paas.cpaas.be.srv.util.AnsibleLocalShellUtils.ansibleExecCommand;

/**
 * shaozhanpeng
 * 2016/3/9
 * AIC
 */
@Service
public class HaproxyServiceImpl implements HaproxyService {

    private static Logger logger = Logger.getLogger(HaproxyServiceImpl.class);

    @Override
    public String addOrUpdate(String newServiceName, String oldServiceName, List<ServiceDO> serviceDOs,String editDate,String cluster) {
        //get acl
        String getAcl = mkAcl(newServiceName,serviceDOs);
        if (null == getAcl) {
            logger.warn("HaproxyService.addOrUpdate haproxy acl canot make");
            return null;
        }

        //get user pwd
        HaproxyInfoDO haproxyInfoDO = MHServiceInfo.getHaproxyInfo(cluster);
        String user = haproxyInfoDO.getUser();
        String passwd = getpasswd(haproxyInfoDO.getPwd());
        if(null == user||null == passwd){
            logger.warn("HaproxyService.addOrUpdate user or passwd canot get");
            return null;
        }

        //get haproxy ips
        List<HaproxyInfoDO> haproxyInfoDOs = MHServiceInfo.getHaproxyInfos(cluster);
        List<String> ips = new ArrayList<>();
        for (HaproxyInfoDO tmp:haproxyInfoDOs) {
            if (null == tmp.getIp()) {
            logger.warn("HaproxyService.addOrUpdate haproxy ip canot get");
                return null;
            }
            ips.add(tmp.getIp());
        }

        try {
            String hostresult = AnsibleHostsConfig.execute(ips,cluster);
            //TODO process hostresult
            String result = AddOrUpdateHaproxyCfg.execute(cluster,user,passwd,newServiceName,getAcl,editDate,oldServiceName);
            return result;

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String queryConfig(HaproxyCfgDO haproxyCfgDO) {
        return null;
    }

    @Override
    public String delConfig(String serviceName,String editDate,String cluster) {

        //get user pwd
        HaproxyInfoDO haproxyInfoDO = MHServiceInfo.getHaproxyInfo(cluster);
        String user = haproxyInfoDO.getUser();
        String passwd = getpasswd(haproxyInfoDO.getPwd());
        if(null == user||null == passwd){
            logger.warn("HaproxyService.delConfig user or passwd canot get");
            return null;
        }


        //get haproxy ips
        List<HaproxyInfoDO> haproxyInfoDOs = MHServiceInfo.getHaproxyInfos(cluster);
        List<String> ips = new ArrayList<>();
        for (HaproxyInfoDO tmp:haproxyInfoDOs) {

            if (null == tmp.getIp()) {
                logger.warn("HaproxyService.delConfig haproxy ip canot get");
                return null;
            }
            ips.add(tmp.getIp());
        }

        try {
            String hostresult = AnsibleHostsConfig.execute(ips,cluster);
            //TODO process hostresult
            String result = DelAclHaproxyCfg.execute(cluster,user,passwd,editDate,serviceName);
            return result;

        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public String rollBack(String cluster) {
        //get user pwd
        HaproxyInfoDO haproxyInfoDO = MHServiceInfo.getHaproxyInfo(cluster);
        String user = haproxyInfoDO.getUser();
        String passwd = getpasswd(haproxyInfoDO.getPwd());

        //get haproxy ips
        List<HaproxyInfoDO> haproxyInfoDOs = MHServiceInfo.getHaproxyInfos(cluster);
        List<String> ips = new ArrayList<>();
        for (HaproxyInfoDO tmp:haproxyInfoDOs) {
            ips.add(tmp.getIp());
        }

        try {
            String hostresult = AnsibleHostsConfig.execute(ips,cluster);
            //TODO process hostresult
            String result = RollBackHaproxyCfg.execute(cluster,user,passwd);
            return result;

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    //获取acl配置
    public static String mkAcl ( String serviceName,List<ServiceDO> serviceDOs ) {
        String minresult = "";
        int num = 1;

        for (ServiceDO tmp:serviceDOs) {
            //TODO ServiceDOInfo shoudbe all exist
            if (null == tmp.getIp() || null == tmp.getPort()) return null;
            minresult = minresult +"server__" + serviceName + "_server-" + num + "__" + tmp.getIp() + ":" + tmp.getPort() + "__check__";
            num  = num +1;
        }
        String result  =  "acl__" + serviceName +"__path_beg__-i__/" + serviceName + "/__use_backend__" + serviceName + "_servers__if__" + serviceName + "__backend__" + serviceName +"_servers__balance__source__mode__http__" + minresult;

        return result;
    }

    //获取执行命令
    public static String fillStringByArgs(String str, String[] arr) {
        Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
        while (m.find()) {
            str = str.replace(m.group(), arr[Integer.parseInt(m.group(1))]);
        }
        return str;

    }


    //生成目标host
    public static String getHaproxyHosts (List<String> ips) {

        String Str = "[haproxy]\n";
        String StrN = "\n";
        for (String tmp:ips){
            Str = Str + tmp + StrN;
        }
        return Str;
    }


    //密码解码
    public static String getpasswd (String pwd) {
        return CiperUtil.decrypt(CiperUtil.SECURITY_KEY,pwd);
    }

}
