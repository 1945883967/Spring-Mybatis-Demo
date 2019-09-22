package com.minghai.test;

import com.minghai.dao.IUserDao;
import com.minghai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SecondLevelCacheTest {
    private InputStream in = null;
    SqlSessionFactory sessionFactory = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    /**
     * 测试一级缓存
     *
     */

    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1 = sessionFactory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(41);
        System.out.println(user1);
        sqlSession1.close(); // 一级缓存消失

        SqlSession sqlSession2 = sessionFactory.openSession();
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();




        System.out.println(user1 == user2);
    }



}
