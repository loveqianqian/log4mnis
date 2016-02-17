package com.heren.log4mnis.service;

import org.apache.log4j.spi.LoggingEvent;

/**
 * <p>Description:</p>
 * <p>ProjectName:log4mnis</p>
 * Created by diaozhiwei on 2016/2/17.
 */
public interface ILogService {
    /**
     * 保存mxl数据到数据库
     * @param xml
     */
    void addContextXmlLog(String xml);

    /**
     * 保存json数据到数据库
     * @param json
     */
    void addContextJsonLog(String json);

    /**
     * 保存loggingEvent到数据库
     * @param event
     */
    void addContextLogEventLog(LoggingEvent event);
}
