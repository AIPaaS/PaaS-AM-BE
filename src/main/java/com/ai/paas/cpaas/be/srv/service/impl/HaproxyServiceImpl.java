package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.AddOrUpdateHaproxyCfg;
import com.ai.paas.cpaas.be.srv.DelAclHaproxyCfg;
import com.ai.paas.cpaas.be.srv.RollBackHaproxyCfg;
import com.ai.paas.cpaas.be.srv.manage.model.HaproxyInfoDO;
import com.ai.paas.cpaas.be.srv.manage.model.haproxy.HaproxyCfgDO;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.HaproxyService;
import com.ai.paas.cpaas.be.srv.util.MHServiceInfo;
import org.apache.log4j.Logger;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
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

    /**ansible creat haproxyip hosts
     * 0 path 1 hosts 2 hostip
     * */
    public static final String ADD_ANSIBLE_HAPROXYHOSTS = "{0}/creat_ansible_hosts.sh {1} {2}";

    /**ansible addorupdate
     * 0 path 1 user 2 passwd(sudo nopasswd) 3 newservername 4 server acl 5 editdate 6 oldservername
     * */
    public static final String ADDORUPDATE_ANSIBLE_HAPROXY = "{0}/addorupdate_ansible_haproxy.sh {1} {2} {3} {4} {5} {6}";
    /**ansible rollback
     * 0 path 1 user 2 passwd(sudo nopasswd)
     * */
    public static final String ROLlBACK_ANSIBLE_HAPROXY = "{0}/rollback_ansible_haproxy.sh {1} {2}";

    /**ansible del
     * 0 path 1 user 2 passwd(sudo nopasswd) 3 servername 4 editdate
     * */
    public static final String DEL_ANSIBLE_HAPROXY = "{0}/del_ansible_haproxy.sh {1} {2} {3} {4}";

    /**
     * shell Path
    * */
    public static final String ANSIBLE_PATH = "/etc/ansible";

    @Override
    public String addOrUpdate(String newServiceName, String oldServiceName, List<ServiceDO> serviceDOs,String editDate,String cluster) {
        //get acl
        String getAcl = mkAcl(newServiceName,serviceDOs);
        //get user pwd
        HaproxyInfoDO haproxyInfoDO = MHServiceInfo.getHaproxyInfo(cluster);
        String user = haproxyInfoDO.getUser();
        String passwd = haproxyInfoDO.getPwd();

        try {
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
        String passwd = haproxyInfoDO.getPwd();

        try {
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
        String passwd = haproxyInfoDO.getPwd();

        try {
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
        //TODO ServiceDO.host shoudbe put into server
        for (ServiceDO tmp:serviceDOs) {
            minresult = minresult +"server__" + serviceName + "_server-" + num + "__" + tmp.getIp() + "：" + tmp.getPort() + "__check__";
            num  = num +1;
        }
        String result  =  "acl__" + serviceName +"__path_beg__-i__/" + serviceName + "/__use_backend__" + serviceName + "_servers__if__access_code_" + serviceName + "__backend__" + serviceName +"_servers__balance__source__mode__http__" + minresult;

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

}
