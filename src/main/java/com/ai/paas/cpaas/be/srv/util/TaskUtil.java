package com.ai.paas.cpaas.be.srv.util;

import com.ai.paas.cpaas.be.am.dao.interfaces.SysCodesMapper;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.SysCodes;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.SysCodesCriteria;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.ServiceUtil;
import org.apache.http.client.ClientProtocolException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/16
 * AIC
 */
public class TaskUtil {


    public static int FINISHED = 2;

    public static int FAILED = 3;


    public static String getSystemProperty(String param) {
        SysCodesCriteria instance = new SysCodesCriteria();
        SysCodesCriteria.Criteria criteria = instance.createCriteria();
        criteria.andCodeKeyEqualTo(param);
        criteria.andSysCodeEqualTo("PROXY");
        SysCodesMapper mapper = ServiceUtil.getMapper(SysCodesMapper.class);
        List<SysCodes> list = mapper.selectByExample(instance);
        return list.get(0).getCodeValue();
    }

    public static String getFile(InputStream in) throws IOException {
        // InputStream in = TaskUtil.class.getResourceAsStream("/batch/river.yml");
        // InputStream in = TaskUtil.class.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }


    public static void uploadFile(String filename, String content, Boolean useAgent, String aid)
            throws ClientProtocolException, IOException, PaasException {
        RemoteExecuteEnv remoteExecuteEnv = TaskUtil.genEnv(useAgent);
        remoteExecuteEnv.uploadFile(filename, content, aid);
    }

    public static RemoteExecuteEnv genEnv(Boolean useAgent) {
        RemoteExecuteEnv executeEnv = null;
        if (useAgent) {
            executeEnv = new RemoteExecuteEnvImpl();
        }
        return executeEnv;
    }

    public static String executeFile(String filename, String content, Boolean useAgent, String aid)
            throws ClientProtocolException, IOException, PaasException {
        RemoteExecuteEnv executeEnv = TaskUtil.genEnv(useAgent);
        return executeEnv.executeFile(filename, content, aid);
    }

    public static StringBuffer createBashFile() {
        StringBuffer shellContext = new StringBuffer();
        shellContext.append("#!/bin/bash");
        shellContext.append("\n");
        return shellContext;
    }

}
