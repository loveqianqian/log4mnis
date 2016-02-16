package com.heren.log4mnis.thread;

import com.heren.log4mnis.model.Test;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/12
 */
public class ThreadTest {
    public static void main(String[] args) {
        Test test =new Test();
        test.setName("ShiShiYi");
        test.setDeptNo(1);
        SqlThread listener=new SqlThread(test);
        listener.run();
    }
}
