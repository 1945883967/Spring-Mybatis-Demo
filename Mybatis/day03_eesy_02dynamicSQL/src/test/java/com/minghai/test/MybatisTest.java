package com.minghai.test;

import com.minghai.dao.IUserDao;
import com.minghai.domain.QueryVo;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 测试mybatis的CRUD操作
 */
public class MybatisTest {
    private  InputStream in = null;
    IUserDao userDao = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        // 使用工厂对象创建dao
        userDao = sqlSession.getMapper(IUserDao.class);

    }
    // 用于在测试方法执行之后执行
    @After
    public void destory() throws IOException {
        in.close();


    }

    /**
     * 测试查询所有
     */
    @Test
    public void findAll() throws IOException {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    /**
     *测试查询一个对象
     */
    @Test
    public void testFindOne() throws IOException {
        User user = userDao.findById(51);
        System.out.println(user);
    }
    /**
     *根据名字模糊查询
     */
    @Test
    public void testFindByName() throws IOException {
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试forEach标签的使用
     */
    @Test
    public void testFindInIds(){
        QueryVo queryVo = new QueryVo();
        queryVo.setIds(Arrays.asList(41,42,41,43));
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    /**
     * 根据条件查询
     */
    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUsername("老王");
        user.setSex("男");
        List<User> users = userDao.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }


}
