package com.ai.paas.cpaas.be.srv.vo;

import com.ai.paas.cpaas.be.srv.util.ExceptionCodeConstants;

import java.io.Serializable;

/**
 * shaozhanpeng
 * 2016/3/17
 * AIC
 */
public class HaproxyResultVo  implements Serializable{

    private static final long serialVersionUID = 5915023903815180766L;

     private String code;
     private String accessUrl;
     private String msg;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code.equals("0")){
            this.code = ExceptionCodeConstants.DubboServiceCode.SUCCESS_CODE;
        }else {
            this.code = ExceptionCodeConstants.DubboServiceCode.SYSTEM_ERROR_CODE;
        }

    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
