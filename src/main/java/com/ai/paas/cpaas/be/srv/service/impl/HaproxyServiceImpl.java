package com.ai.paas.cpaas.be.srv.service.impl;

import com.ai.paas.cpaas.be.srv.manage.model.haproxy.HaproxyCfgDO;
import com.ai.paas.cpaas.be.srv.manage.model.mesos.ServiceDO;
import com.ai.paas.cpaas.be.srv.service.HaproxyService;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.log4j.Logger;

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

    /**ansible addorupdate
     * 0 path 1 user 2 passwd(sudo nopasswd) 3 newservername 4 server acl 5 editdate 6 oldservername
     * */
    public static final String ADD_ANSIBLE_HAPROXY = "{0}/init_ansible_ssh_hosts.sh {1} {2} {3} {4} {5}";
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

    //test
    //TODO get u p from sql
    public static final String user = "shaotest";
    public static final String passwd = "sss008";


    @Override
    public boolean addOrUpdate(String newServiceName, String oldServiceName, List<ServiceDO> serviceDOs,String editDate) {
        //get acl
        String mkAcl = getAcl(newServiceName,serviceDOs);

        //get shell
        String mkShell = fillStringByArgs(
                ADDORUPDATE_ANSIBLE_HAPROXY,
                new String[]{
                        ANSIBLE_PATH,
                        user,
                        passwd,
                        newServiceName,
                        mkAcl,
                        editDate,
                        oldServiceName
                }
        );
        //run shell
        boolean result = ansibleExecCommand(mkShell);

        return result;
    }

    @Override
    public String queryConfig(HaproxyCfgDO haproxyCfgDO) {
        return null;
    }

    @Override
    public boolean delConfig(String serviceName,String editDate) {


        //get shell
        String mkShell = fillStringByArgs(
                DEL_ANSIBLE_HAPROXY,
                new String[]{
                        ANSIBLE_PATH,
                        user,
                        passwd,
                        serviceName,
                        editDate
                }
        );

        //run shell
        boolean result = ansibleExecCommand(mkShell);

        return result;
    }

    @Override
    public boolean rollBack() {
        //get shell
        String mkShell = fillStringByArgs(
                ROLlBACK_ANSIBLE_HAPROXY,
                new String[]{
                        ANSIBLE_PATH,
                        user,
                        passwd
                }
        );
        boolean result = ansibleExecCommand(mkShell);

        return result;
    }

    //获取acl配置
    public static String getAcl ( String serviceName,List<ServiceDO> serviceDOs ) {
        String minresult = "";
        int num = 1;
        //TODO ServiceDO.host shoudbe put into server
        for (ServiceDO tmp:serviceDOs) {
            minresult = minresult +"server__" + serviceName + "_server-" + num + "__" + tmp.getIp() + "：" + tmp.getPort() + "__check__";
            num  = num +1;
        }
        String result  =  "acl__access_code_" + serviceName +"__path_beg__-i__/" + serviceName + "/__use_backend__" + serviceName + "_servers__if__access_code_" + serviceName + "__backend__" + serviceName +"_servers__balance__source__mode__http__" + minresult;

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


}
