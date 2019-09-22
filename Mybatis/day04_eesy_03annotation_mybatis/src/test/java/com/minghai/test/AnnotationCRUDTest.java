package com.minghai.test;

import com.minghai.dao.IUserDao;
import com.minghai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
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
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("杭州萧山区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.svaeUser(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(57);
        user.setUsername("mybatis annotation new");
        user.setAddress("上海浦东1111");
        user.setSex("男");

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(58);
    }
    @Test
    public void testSelectOne(){
        User user = userDao.findById(57);
        System.out.println(user);
    }
    @Test
    public void testfindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testfindByName1(){
        List<User> users = userDao.findUserByName1("王%' or 1=1-- ");
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testSelectTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
