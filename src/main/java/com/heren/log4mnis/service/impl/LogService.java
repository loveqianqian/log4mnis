package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.dao.LogMapper;
import com.heren.log4mnis.model.Log;
import com.heren.log4mnis.service.ILogService;
import com.heren.log4mnis.util.MyStringUtils;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * <p>Description:</p>
 * <p>ProjectName:log4mnis</p>
 * Created by diaozhiwei on 2016/2/17.
 */

@Service
public class LogService implements ILogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存mxl数据到数据库
     *
     * @param xml
     */
    @Override
    public void addContextXmlLog(String xml) {

    }

    /**
     * 保存json数据到数据库
     *
     * @param json
     */
    @Override
    public void addContextJsonLog(String json) {

    }

    /**
     * 保存loggingEvent到数据库
     *
     * @param event
     */
    @Override
    public void addContextLogEventLog(LoggingEvent event) {
        String message= (String) event.getMessage();
        Log log=new Log();
        log.setTimestamp(System.currentTimeMillis());
        try {
            log.setContent(message.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (MyStringUtils.isJson(message)) {
            log.setContentType("json");
        }else{
            log.setContentType("xml");
        }
//        log.setType();
        logMapper.addLog(log);

    }
}
