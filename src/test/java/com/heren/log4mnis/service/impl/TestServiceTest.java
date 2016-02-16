package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:testService的测试类</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestServiceTest {

    @Autowired
    private ITestService testService;

    @Test
    public void testAddTest() throws Exception {
        com.heren.log4mnis.model.Test t = new com.heren.log4mnis.model.Test();
        t.setId(11);
        t.setName("springMybatisThird");
        t.setDeptNo(1);
        testService.addTest(t);
    }

    @Test
    public void testDelTest() throws Exception {
        testService.delTest(11);
    }

    @Test
    public void testModTest() throws Exception {
        com.heren.log4mnis.model.Test t = new com.heren.log4mnis.model.Test();
        t.setId(10);
        t.setName("springMybatisThird");
        t.setDeptNo(1);
        testService.modTest(t);
    }

    @Test
    public void testQueryTest() throws Exception {
        List<com.heren.log4mnis.model.Test> tests = testService.queryTest();
        for (com.heren.log4mnis.model.Test test : tests) {
            System.out.println(test.getId() + ":" + test.getName() + ":" + test.getDeptNo());
        }
    }
}