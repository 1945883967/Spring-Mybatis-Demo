package com.minghai.mybatis.sqlsession.defaults;

import com.minghai.domain.User;
import com.minghai.mybatis.cfg.Configuration;
import com.minghai.mybatis.sqlsession.SqlSession;
import com.minghai.mybatis.sqlsession.proxy.MapperProxy;
import com.minghai.mybatis.utils.DataSourcesUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;

    private Connection conn;

    public  DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.conn = DataSourcesUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
