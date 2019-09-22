package com.minghai.dao.impl;

import com.minghai.dao.IUserDao;
import com.minghai.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        List<User> users =  sqlSession.selectList("com.minghai.dao.IUserDao.findAll");// 参数能获取的配置信息key
        // 3.释放资源
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.minghai.dao.IUserDao.saveUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.minghai.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer id) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.minghai.dao.IUserDao.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }

    public User findById(int userId) {
        // 1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        User user =  sqlSession.selectOne("com.minghai.dao.IUserDao.findById",userId);// 参数能获取的配置信息key
        // 3.释放资源
        sqlSession.close();
        return user;
    }

    public List<User> findByName(String username) {
        // 1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        List<User> users =  sqlSession.selectList("com.minghai.dao.IUserDao.findByName",username);// 参数能获取的配置信息key
        // 3.释放资源
        sqlSession.close();
        return users;
    }

    public int findCount() {
        SqlSession sqlSession = factory.openSession();
        int count = sqlSession.selectOne("com.minghai.dao.IUserDao.findCount");
        return count;
    }
}
