package com.minghai.service.impl;

import com.minghai.service.AccountService;

import java.util.Date;

/**
 * @author minghai
 * @date 2019/6/30 - 19:02
 * 账户业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;



    public  void saveAccount(){
        System.out.println("Service中的saveAccount方法执行了"+name+","+birthday+","+age);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
