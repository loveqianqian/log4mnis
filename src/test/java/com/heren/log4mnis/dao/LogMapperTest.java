package com.heren.log4mnis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.rmi.runtime.Log;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:lm_log test</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class LogMapperTest {

    @Autowired
    private LogMapper logMapper;

    @Test
    public void testAddLog() throws Exception {
        String xml = "<test><id>2</id><name>aaron</name></test>";
        com.heren.log4mnis.model.Log log = new com.heren.log4mnis.model.Log();
        log.setType("system");
        log.setTimestamp(System.currentTimeMillis());
        log.setContent(xml.getBytes());
        log.setContentType("xml");
        log.setOriginal("webService");
        log.setCode("003");
        log.setKeyWords("web,service,client");
        logMapper.addLog(log);
    }

    @Test
    public void testDelLogById() throws Exception {
        Map<String,Object> params=new HashMap<>();
        params.put("logId",6);
        logMapper.delLogById(params);
    }

    @Test
    public void testDelLogByTimeStamp() throws Exception {
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(1455605977112l);
        Map<String,Object> params=new HashMap<>();
        params.put("startTime",calendar.getTimeInMillis());
        params.put("endTime",System.currentTimeMillis());
        logMapper.delLogByTimeStamp(params);
    }

    @Test
    public void testQueryLog() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        List<com.heren.log4mnis.model.Log> logs = logMapper.queryLog(params);
        for (com.heren.log4mnis.model.Log log : logs) {
            System.out.println(log.toString());
        }
    }
}