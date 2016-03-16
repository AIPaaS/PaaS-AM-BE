package com.ai.paas.cpaas.be.srv.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * shaozhanpeng
 * 2016/3/7
 * AIC
 */
@ContextConfiguration("classpath:context/applicationContext-am.xml")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "/applicationContext-am.xml" })
public class MesosServiceTest {
    @Autowired
    private MesosService mesosService;

    @Test
    public void testGetVersion() throws Exception {

    }

    @Test
    public void testGetConfig() throws Exception {
//        String config = mesosService.getConfig();
//        System.out.println(config);
    }

    @Test
    public void testGetHosts() throws Exception {

    }

    @Test
    public void testGetServices() throws Exception {

    }
}