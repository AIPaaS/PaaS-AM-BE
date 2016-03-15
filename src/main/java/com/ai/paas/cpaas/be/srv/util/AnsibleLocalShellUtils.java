package com.ai.paas.cpaas.be.srv.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * shaozhanpeng
 * 2016/3/14
 * AIC
 */
public class AnsibleLocalShellUtils {
    private static final transient Logger log = LoggerFactory.getLogger(AnsibleLocalShellUtils.class);


    public static boolean ansibleExecCommand(String cmd) {
        if(log.isDebugEnabled()) {
            log.debug(cmd);
        }

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            int exitValue = process.waitFor();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            if(result==null)
                return false;
            log.debug("---------command--{}-----res--{}----------",cmd,result);

            if (0 != exitValue)
                log.error("ansible haproxy shell failed. error code is :" + exitValue);
            return exitValue==0&&(!result.contains("FAILED"));

        } catch (Exception e) {
            log.error("ansible haproxy shell Exception", e);
            return false;
        }
    }



}
