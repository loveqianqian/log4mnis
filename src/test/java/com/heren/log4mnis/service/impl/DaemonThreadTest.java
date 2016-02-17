package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.model.Log;
import com.heren.log4mnis.service.impl.DaemonThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DaemonThreadTest {

    @Autowired
    private DaemonThread daemonThread;

    @Test
    public void testDaemonThread() {
        final String xml = "<text>\n" +
                "\t<id>1</id>\n" +
                "\t<name>zhiwei</name>\n" +
                "</text>";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Log log = new Log();
                    long l1 = System.currentTimeMillis();
                    log.setTimestamp(l1);
                    log.setContent(xml.getBytes());
                    log.setType("system");
                    log.setContentType("xml");
                    daemonThread.addTask(l1, log);
                }
            }
        });
        thread.start();
        thread.run();
        daemonThread.run();
    }

    @Test
    public void testOtherDaemonThread() {
        String xml = "<text>\n" +
                "\t<id>1</id>\n" +
                "\t<name>zhiwei</name>\n" +
                "</text>";
        Log log = new Log();
        long l1 = System.currentTimeMillis();
        log.setTimestamp(l1);
        log.setContent(xml.getBytes());
        log.setType("system");
        log.setContentType("xml");
        daemonThread.addTask(l1, log);
    }

}