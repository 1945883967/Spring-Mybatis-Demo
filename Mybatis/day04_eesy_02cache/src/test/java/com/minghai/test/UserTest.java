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
import java.util.List;

public class UserTest {
    private InputStream in = null;
    IUserDao userDao = null;
    SqlSession sqlSession = null;
    SqlSessionFactory sessionFactory = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sessionFactory.openSession();
        // 使用工厂对象创建dao
        userDao = sqlSession.getMapper(IUserDao.class);

    }
    // 用于在测试方法执行之后执行
    @After
    public void destory() throws IOException {
        in.close();
    }

    /**
     * 测试一级缓存
     *
     */

    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);

//        sqlSession.close();
//        sqlSession = sessionFactory.openSession();
//        userDao = sqlSession.getMapper(IUserDao.class);

        sqlSession.clearCache();

        User user2 = userDao.findById(41);
        System.out.println(user2);



        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
        // 更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("北京海淀区");
        user1 = userDao.findById(41);
        userDao.updateUser(user1);
        // 再次查询id为41的用户

        User user2 = userDao.findById(41);
        System.out.println(user2);



        System.out.println(user1 == user2);
    }


}
