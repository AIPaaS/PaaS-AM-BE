package com.ai.paas.cpaas.be.srv.util;

import com.ai.paas.ipaas.PaasException;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * shaozhanpeng
 * 2016/3/16
 * AIC
 */
public interface RemoteExecuteEnv {

    public String executeFile(String filename, String content, String aid)
            throws ClientProtocolException, IOException, PaasException;

    public void uploadFile(String filename, String content, String aid)
            throws ClientProtocolException, IOException, PaasException;

    public String executeCommand(String content, String aid) throws ClientProtocolException,
            IOException, PaasException;

}
