package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.dao.LogMapper;
import com.heren.log4mnis.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:一个子线程，用于保存log日志到数据库中</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
@Service
@Transactional(readOnly = true)
public class DaemonThread extends Thread {

    @Autowired
    private LogMapper logMapper;

    private Map<Long, Object> tasks = new HashMap<>();
    private volatile boolean finished = false;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void run() {
        while (!finished) {
            if (tasks.isEmpty()) {
                TemporaryStorage storage = new TemporaryStorage();
                Map<Long, Object> map = storage.delTask();
                tasks = map;
            }
            Log log = null;
            try {
                log = getEarly();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            logMapper.addLog(log);
        }
    }

    public Log getEarly() throws UnsupportedEncodingException {
        Log log;
        Long timestampEarly = tasks.keySet().iterator().next();
        for (Long l : tasks.keySet()) {
            if (timestampEarly - l > 0) {
                timestampEarly = l;
            }
        }
        log = (Log) tasks.get(timestampEarly);
        tasks.remove(timestampEarly);
        return log;
    }

    public void addTask(Long timestamp, Object task) {
        tasks.put(timestamp, task);
    }

    public void stopMe() {
        finished = true;
    }

    public Map<Long, Object> getTasks() {
        return tasks;
    }

    public void setTasks(Map<Long, Object> tasks) {
        this.tasks = tasks;
    }
}
