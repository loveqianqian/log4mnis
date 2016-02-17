package com.heren.log4mnis.log4jTest;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * <p>Description:</p>
 * <p>ProjectName:log4mnis</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/6
 */
public class LogTest {

    private static Logger logger = Logger.getLogger(LogTest.class);

    @Test
    public void testLog4j(){
        System.out.println("print message");
        logger.debug("this is a debug");
        logger.info("this is a info");
        logger.error("this is a error");
    }
}
