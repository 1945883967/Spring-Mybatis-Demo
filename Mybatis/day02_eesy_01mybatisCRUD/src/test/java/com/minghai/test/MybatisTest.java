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
import java.util.Date;
import java.util.List;


/**
 * 测试mybatis的CRUD操作
 */
public class MybatisTest {
    private  InputStream in = null;
    SqlSession sqlSession = null;
    IUserDao userDao = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    // 用于在测试方法执行之后执行
    @After
    public void destory() throws IOException {
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
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
     *测试保存对象
     */
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("北京市");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }

    /**
     *测试更新对象
     */
    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(51);
        user.setUsername("mybatis ");
        user.setAddress("北京市");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }
    /**
     *测试删除对象
     */
    @Test
    public void testDelete() throws IOException {
        userDao.deleteUser(48);
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
     * 查询总用户数
     */
    @Test
    public void testfindCount(){
        int count = userDao.findCount();
        System.out.println(count);
    }

    /**
     * 使用QueryVo作为查询条件
     */
    @Test
    public void testFindByQueryVo() throws IOException {
        QueryVo vo = new QueryVo();
        User user1= new User();
        user1.setUsername("%王%");
        vo.setUser(user1);
        List<User> users = userDao.findUserByVo(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
