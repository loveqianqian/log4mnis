package com.heren.log4mnis.mybatis;

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
 * @data:2016/2/11
 */
public class MybatisTest {
    public static void main(String[] args) {
        String file = "mybatis.config.test.xml";
        InputStream stream = MybatisTest.class.getClassLoader().getResourceAsStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.heren.log4mnis.model.Test.loadTest";
        Test test = sqlSession.selectOne(statement);
        System.out.println(test);
    }
}
