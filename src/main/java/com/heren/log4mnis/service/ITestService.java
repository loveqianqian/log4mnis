package com.heren.log4mnis.service;

import com.heren.log4mnis.model.Test;

import java.util.List;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/15
 */
public interface ITestService {
    /**
     * 增加mnistest.db 测试
     *
     * @param params
     */
    void addTest(Test params);

    /**
     * 删除一条emp测试
     * @param id
     */
    void delTest(int id);

    /**
     * 修改一条emp测试
     * @param test
     */
    void modTest(Test test);

    /**
     * 查询emp记录，如果id为0，查询所有
     * @return
     */
    List<Test> queryTest();
}
