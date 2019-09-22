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

public class SecondLevelCacheTest  {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void testBefor() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void testAfter() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSelectOne(){
        User user = userDao.findById(57);
        System.out.println(user);

        sqlSession.close();

        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        User user1 = userDao.findById(57);
        System.out.println(user1);

        System.out.println(user == user1);

    }
}
