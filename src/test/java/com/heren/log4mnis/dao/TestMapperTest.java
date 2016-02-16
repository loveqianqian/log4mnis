package com.heren.log4mnis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:spring+mybatis 整合测试</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testLoadTest() throws Exception {
        List<com.heren.log4mnis.model.Test> tests = testMapper.loadTest();
        for (com.heren.log4mnis.model.Test test : tests) {
            System.out.println(test.getName());
        }
    }

    @Test
    public void testAddTestAuto() throws Exception {
        com.heren.log4mnis.model.Test t=new com.heren.log4mnis.model.Test();
        t.setDeptNo(1);
        t.setName("springMybatisTestTwice");
        testMapper.addTestAuto(t);
    }

    @Test
    public void testDelTest() throws Exception {
        com.heren.log4mnis.model.Test t=new com.heren.log4mnis.model.Test();
        t.setId(11);
        testMapper.delTest(t);
    }

    @Test
    public void testModTest() throws Exception{
        com.heren.log4mnis.model.Test t=new com.heren.log4mnis.model.Test();
        t.setId(9);
        t.setName("springMybatis");
        t.setDeptNo(1);
        testMapper.modTest(t);
    }
}