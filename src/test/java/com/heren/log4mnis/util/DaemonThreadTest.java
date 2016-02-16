package com.heren.log4mnis.util;

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
        String xml = "<text>\n" +
                "\t<id>1</id>\n" +
                "\t<name>zhiwei</name>\n" +
                "</text>";
        daemonThread.addTask(System.currentTimeMillis(), xml);
        daemonThread.run();
    }

}