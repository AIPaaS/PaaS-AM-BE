package com.ai.paas.cpaas.be.srv;

import com.ai.paas.cpaas.be.srv.util.AnsibleCommand;
import com.ai.paas.cpaas.be.srv.util.ExceptionCodeConstants;
import com.ai.paas.cpaas.be.srv.util.TaskUtil;
import com.ai.paas.ipaas.PaasException;
import com.esotericsoftware.minlog.Log;
import org.apache.log4j.Logger;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/17
 * AIC
 */
public class DelAclHaproxyCfg {
    private static Logger logger = Logger.getLogger(DelAclHaproxyCfg.class);


    public static String execute(String clusterId, String user, String password, String haproxydate, String oldservername) throws Exception {
        //远程调用
        boolean useAgent = true;

        //upload file
        InputStream in = DelAclHaproxyCfg.class.getResourceAsStream("/playbook/haproxy/del_haproxy.yml");
        String content = TaskUtil.getFile(in);
        TaskUtil.uploadFile("del_haproxy.yml", content, useAgent, clusterId);

        List<String> configvars = new ArrayList<String>();
        configvars.add("ansible_ssh_pass=" + password);
        configvars.add("ansible_become_pass=" + password);
        configvars.add("hosts=haproxy");
        configvars.add("user=" + user);
        configvars.add("haproxydate=" + haproxydate);
        configvars.add("oldservername=" + oldservername);

        //TODO need my hosts
        AnsibleCommand command =
                new AnsibleCommand(TaskUtil.getSystemProperty("filepath") + "/del_haproxy.yml -i /etc/ansible/haproxy_hosts", user,
                        configvars);

        String result = new String();
        int status = TaskUtil.FINISHED;
        try {
            //shell start
            result = TaskUtil.executeFile("delaclhaproxy", command.toString(), useAgent, clusterId);
        } catch (Exception e) {
            logger.error(e.toString());
            result = e.toString();
            status = TaskUtil.FAILED;
            throw new PaasException(ExceptionCodeConstants.DubboServiceCode.SYSTEM_ERROR_CODE,
                    e.toString());
        }finally {
            logger.info(result);
            System.out.println(result);
            return result;

        }


    }


}
