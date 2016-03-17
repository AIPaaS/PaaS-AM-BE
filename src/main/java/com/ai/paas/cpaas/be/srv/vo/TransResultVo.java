package com.ai.paas.cpaas.be.srv.vo;

import java.io.Serializable;

/**
 * shaozhanpeng
 * 2016/3/16
 * AIC
 */
public class TransResultVo implements Serializable{

    private static final long serialVersionUID = 3360455865399342331L;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
}
