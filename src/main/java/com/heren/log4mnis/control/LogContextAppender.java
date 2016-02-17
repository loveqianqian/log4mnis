package com.heren.log4mnis.control;

import com.heren.log4mnis.service.ILogService;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:
 * </p>
 *
 * @author:diaozhiwei
 * @data:2016/2/17
 */
@Controller
public class LogContextAppender extends AppenderSkeleton {

    @Autowired
    private ILogService logService;

    /**
     * 初始化加载资源
     */
    @Override
    public void activateOptions() {
        super.activateOptions();
    }

    /**
     * 打印日志核心方法
     *
     * @param event
     */
    @Override
    protected void append(LoggingEvent event) {
        logService.addContextLogEventLog(event);
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {

    }

    /**
     * 是否需要按格式输出文本
     *
     * @return
     */
    @Override
    public boolean requiresLayout() {
        return false;
    }

}
