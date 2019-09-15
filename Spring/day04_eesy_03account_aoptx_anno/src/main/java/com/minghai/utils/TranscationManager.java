package com.minghai.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放事务
 */
@Component("txManager")
@Aspect
public class TranscationManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.minghai.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    public void beginTranscation(){
        try {
            connectionUtils.getThradConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThradConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThradConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionUtils.getThradConnection().close(); // 还回了连接池中
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pij){
        Object rtValue = null;
        try {
            // 1.获取参数
            Object[] args =  pij.getArgs();
            // 2.开启事务
            this.beginTranscation();
            // 3执行任务
            rtValue = pij.proceed(args);
            // 4.提交事务
            this.commit();

            // 返回结果
            return rtValue;
        }catch (Throwable e){
            // 5.回滚事务
            this.rollback();
            throw new RuntimeException();
        }finally {
            // 6.释放资源
            this.release();
        }
    }

}
