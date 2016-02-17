package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.dao.LogMapper;
import com.heren.log4mnis.service.ILogService;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }
}
