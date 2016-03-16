package com.ai.paas.cpaas.be.srv.util;


import com.ai.paas.ipaas.util.ShellUtil;

import java.util.List;

/**
 * shaozhanpeng
 * 2016/3/9
 * AIC
 */
public class HaproxyCfgUtils {

    //creat targethosts string
    public static boolean getHaproxyHosts (List<String> ips) {

        String Str = "[haproxy]\n";
        String StrN = "\n";

        for (String tmp:ips){
            Str = Str + tmp +StrN;
        }

        return false;
    }

}
