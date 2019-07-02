package com.minghai.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author minghai
 * @date 2019/6/30 - 19:13
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用的含义
 * JavaBean：用Java语言编写的可重用组件
 *      javaBean > 实体类
 *
 *
 *     它就是创建我们的service和dao对象
 *     第一个：需要一个配置文件类配置我们的Service和dao
 *              配置文件内容：唯一标全限定类名(key=value)
 *     第二个：通过配置文件中配置的内容，反射创建对象
 *
 *     配置文件：XML也可以是properties
 *
 */
public class BeanFactory {
    // 定义一个Properties对象
    private static Properties props;
    // 创建一个Map，用于存放我们要创建的对象。我们称之为容器
    private static Map<String,Object> beans;

    // 使用静态关键代码块为Properties对象赋值
    static{
       try {
           // 实例化对象
           props = new Properties();
           // 获取properties文件的流对象
           InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
           props.load(in);
           // 实例化容器
           beans = new HashMap<String, Object>();
           // 取出配置文件中所有的key
           Enumeration<Object> keys = props.keys();
           while(keys.hasMoreElements()){
               //  取出每个Key
               String key = keys.nextElement().toString();
               // 根据key获取value
               String beanPath = props.getProperty(key);
               // 反射创建对象
               Object value = Class.forName(beanPath).newInstance();
               // 把key和value存入容器中
               beans.put(key,value);
           }
       }catch (Exception e){
           throw new ExceptionInInitializerError("初始化properties失败");
       }
    }
    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     */
/*    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();// 每次都会调用默认构造函数创建对象
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
