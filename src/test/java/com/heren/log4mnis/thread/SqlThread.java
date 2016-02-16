package com.heren.log4mnis.thread;

import com.heren.log4mnis.model.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/12
 */
public class SqlThread implements Runnable {

    private Test test;

    public SqlThread(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        String file = "mybatis.config.test.xml";
        InputStream stream = ThreadTest.class.getClassLoader().getResourceAsStream(file);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = factory.openSession(true);
        String statement = "com.heren.log4mnis.model.Test.addTestAuto";
        sqlSession.insert(statement, test);
        sqlSession.commit();
        sqlSession.close();
    }
}
