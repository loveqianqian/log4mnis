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
public class MybatisAddTest {
    public static void main(String[] args) {
        String file = "mybatis.config.test.xml";
        InputStream stream = MybatisAddTest.class.getClassLoader().getResourceAsStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement2 = "com.heren.log4mnis.model.Test.addTest";
        Test test2 = new Test();
        test2.setId(11);
        test2.setName("Mr.test");
        test2.setDeptNo(1);
        int insert = sqlSession.insert(statement2, test2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("insert:" + insert);
    }
}
