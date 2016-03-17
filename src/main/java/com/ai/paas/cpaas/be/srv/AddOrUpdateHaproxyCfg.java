package com.ai.paas.cpaas.be.srv;

import com.ai.paas.cpaas.be.srv.util.AnsibleCommand;
import com.ai.paas.cpaas.be.srv.util.ExceptionCodeConstants;
import com.ai.paas.cpaas.be.srv.util.TaskUtil;
import com.ai.paas.ipaas.PaasException;
import com.esotericsoftware.minlog.Log;
import org.apache.catalina.User;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/16
 * AIC
 */
public class AddOrUpdateHaproxyCfg {

    public static String execute(String clusterId,String user,String password,String newservername,String insertacl,String haproxydate,String oldservername) throws Exception {
        //远程调用
        boolean useAgent = true;

        //upload file
        InputStream in = AddOrUpdateHaproxyCfg.class.getResourceAsStream("/playbook/haproxy/addorupdate_haproxy.yml");
        String content = TaskUtil.getFile(in);
        TaskUtil.uploadFile("addorupdate_haproxy.yml", content, useAgent, clusterId);

        List<String> configvars = new ArrayList<String>();
        configvars.add("ansible_ssh_pass=" + password);
        configvars.add("ansible_become_pass=" + password);
        configvars.add("hosts=haproxy");
        configvars.add("user=" + user);
        configvars.add("newservername=" + newservername);
        configvars.add("insertacl=" + insertacl);
        configvars.add("haproxydate=" + haproxydate);
        configvars.add("oldservername=" + oldservername);

        //TODO need my hosts
        AnsibleCommand command =
                new AnsibleCommand(TaskUtil.getSystemProperty("filepath") + "/addorupdate_haproxy.yml -i /etc/ansible/haproxy_hosts", user,
                        configvars);

        String result = new String();
        int status = TaskUtil.FINISHED;
        try {
            //shell start
            result = TaskUtil.executeFile("addorupdatehaproxy", command.toString(), useAgent, clusterId);
        } catch (Exception e) {
            Log.error(e.toString());
            result = e.toString();
            status = TaskUtil.FAILED;
            throw new PaasException(ExceptionCodeConstants.DubboServiceCode.SYSTEM_ERROR_CODE,
                    e.toString());
        }finally {
            //TODO
            System.out.println(result);
            return result;
        }

    }

}