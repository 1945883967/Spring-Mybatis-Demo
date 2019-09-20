package com.minghai.mybatis.utils;

import com.minghai.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于创建数据源的工具类
 */
public class DataSourcesUtil {
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
           return  DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
