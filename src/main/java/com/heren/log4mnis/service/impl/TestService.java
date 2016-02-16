package com.heren.log4mnis.service.impl;

import com.heren.log4mnis.dao.TestMapper;
import com.heren.log4mnis.model.Test;
import com.heren.log4mnis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/15
 */
@Service("testService")
@Transactional(readOnly = true)
public class TestService implements ITestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 增加mnistest.db 测试
     *
     * @param params
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void addTest(Test params) {
        testMapper.addTestAuto(params);
    }

    /**
     * 删除一条emp测试
     *
     * @param id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void delTest(int id) {
        testMapper.delTest(new Test(id));
    }

    /**
     * 修改一条emp测试
     *
     * @param test
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void modTest(Test test) {
        testMapper.modTest(test);
    }

    /**
     * 查询emp记录
     *
     * @return
     */
    @Override
    public List<Test> queryTest() {
        List<Test> tests = testMapper.loadTest();
        return tests;
    }


}
