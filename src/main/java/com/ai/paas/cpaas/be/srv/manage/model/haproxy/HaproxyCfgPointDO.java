package com.ai.paas.cpaas.be.srv.manage.model.haproxy;

/**
 * shaozhanpeng
 * 2016/3/24
 * AIC
 */
public class HaproxyCfgPointDO {
    private String acl;
    private String useBackend;
    private String backend;


    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public String getUseBackend() {
        return useBackend;
    }

    public void setUseBackend(String useBackend) {
        this.useBackend = useBackend;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }
}
