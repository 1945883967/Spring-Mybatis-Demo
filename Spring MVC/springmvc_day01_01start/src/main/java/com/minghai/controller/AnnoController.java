package com.minghai.controller;

import com.minghai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) // 把msg= minghai 存入到session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(){
        System.out.println("执行了.....");
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String head){
        System.out.println(head);
        return "success";
    }

    /**
     * testRequestBosy
     * @param body
     * @return
     */
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }


    /**
     * testPathVariable
     * @param id
     * @return
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println(id);
        return "success";
    }
    /**
     * testPathVariable
     * @param
     * @return
     */
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("执行了.....");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public  void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了......");
        // 通过查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }


   /* *//**
     * 该方法先执行
     *//*
    @ModelAttribute
    public  User showUser(String uname){
        System.out.println("showUser执行了......");
        // 通过查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * testSessionAttribute注解
     * @return
     */
    @RequestMapping(path = "/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("testSessionAttribute.......");
        // 向session域中存值
        model.addAttribute("msg","minghai");
        return "success";
    }
    /** 取值
     * testSessionAttribute注解
     * @return
     */
    @RequestMapping(path = "/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("testSessionAttribute.......");
        // 底层会存储到request域对象中
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }
    /** 删除
     * testSessionAttribute注解
     * @return
     */
    @RequestMapping(path = "/delSessionAttribute")
    public String delSessionAttribute(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "success";
    }
}
