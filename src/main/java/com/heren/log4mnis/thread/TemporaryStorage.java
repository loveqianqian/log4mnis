package com.heren.log4mnis.thread;

import com.heren.log4mnis.model.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:临时保存log</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
public class TemporaryStorage {

    private static Map<Long, Object> tasks = new HashMap<>();
    Object lock = new Object();

    public void addTask(Log log) {
        synchronized (lock) {
            tasks.put(System.currentTimeMillis(), log);
            lock.notifyAll();
        }
    }

    public Map<Long, Object> delTask() {
        Map<Long, Object> newTasks;
        synchronized (lock) {
            newTasks = tasks;
            tasks.clear();
            lock.notifyAll();
        }
        return newTasks;
    }


}
