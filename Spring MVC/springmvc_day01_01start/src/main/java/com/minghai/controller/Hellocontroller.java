package com.minghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 控制器
@Controller
@RequestMapping(path = "user")
public class Hellocontroller {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * 测试RequestMapping注解
     * @return
     */
    @RequestMapping(path = "testRequestMapping",method = {RequestMethod.POST})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
