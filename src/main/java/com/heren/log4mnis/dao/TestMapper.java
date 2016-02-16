package com.heren.log4mnis.dao;

import com.heren.log4mnis.model.Test;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:测试</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/12
 */
public interface TestMapper {
    /**
     * 获取emp表中所有的数据
     *
     * @return
     */
    List<Test> loadTest();

    /**
     * 根据test中值插入emp
     *
     * @param param
     */
    void addTest(Test param);

    /**
     * 根据test中的值，自增长主键
     *
     * @param param
     */
    void addTestAuto(Test param);

    /**
     * 删除emp中的数据
     * @param param
     */
    void delTest(Test param);

    /**
     * 修改emp中的数据
     * @param param
     */
    void modTest(Test param);
}
