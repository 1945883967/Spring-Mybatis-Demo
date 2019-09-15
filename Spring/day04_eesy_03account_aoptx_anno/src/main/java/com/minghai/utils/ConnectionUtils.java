package com.minghai.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.concurrent.ExecutionException;

/**
 * 连接工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;


    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThradConnection(){
        // 1.先从ThreadLocal上获取
        Connection conn = tl.get();
        try{
            // 2.判断当前线程上是否有连接
            if(conn == null){
                // 3.从数据源中获取一个连接，并存入ThreadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把线程和连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }

}
