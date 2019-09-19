package com.minghai.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取文件的类
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流来创建一个SqlSessionFactory工厂
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
