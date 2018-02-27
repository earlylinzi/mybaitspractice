package com.early.mybatis.practice.test;

import com.early.mybatis.practice.domain.Composition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisTest {





    public static void testQueryUserById() throws Exception {
        SqlSessionFactory sqlSessionFactory = null;

        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        Composition composition = (Composition)sqlSession.selectOne("queryCompositionById", 1);

        // 6. 打印结果
        System.out.println(composition.getText());

        // 7. 释放资源
        sqlSession.close();
    }

    public static void main(String[] args) {

        try {
            testQueryUserById();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

