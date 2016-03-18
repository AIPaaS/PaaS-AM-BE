package com.ai.paas.cpaas.be.srv;

import com.ai.paas.cpaas.be.srv.util.ExceptionCodeConstants;
import com.ai.paas.cpaas.be.srv.util.TaskUtil;
import com.ai.paas.ipaas.PaasException;
import com.esotericsoftware.minlog.Log;
import org.apache.log4j.Logger;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/16
 * AIC
 */
public class AnsibleHostsConfig {

    private static Logger logger = Logger.getLogger(AnsibleHostsConfig.class);

    /**
     * 创建ansible执行目标haproxy服务器hosts
     * @param ips 集群 haproxy ip
     * @param aid 集群ID
     */

    public static String execute(List<String> ips,String aid) throws Exception {



        boolean useAgent = true;

        // create execute file
        StringBuffer shellContext = TaskUtil.createBashFile();
        //TODO hosts file path
        shellContext.append("touch /etc/ansible/haproxy_hosts");
        shellContext.append("\n");
        shellContext.append("cat >/etc/ansible/haproxy_hosts <<-EOL");
        shellContext.append("\n");

        //添加IP组
        shellContext.append("[haproxy]");
        shellContext.append("\n");

        for (String tmp:ips) {
            shellContext.append(tmp);
            shellContext.append("\n");
        }

        shellContext.append("EOL");
        shellContext.append("\n");

        String result = new String();
        int status = TaskUtil.FINISHED;
        try {
            result = TaskUtil.executeFile("configAnsibleHosts", shellContext.toString(), useAgent, aid);
            return result;
        } catch (Exception e) {
            logger.error(e.toString());
            result = e.toString();
            status = TaskUtil.FAILED;
            throw new PaasException(ExceptionCodeConstants.DubboServiceCode.SYSTEM_ERROR_CODE,
                    e.toString());
        } finally {
            logger.info(result);
            System.out.println(result);
            return result;

        }

    }
}
