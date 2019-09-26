package com.minghai.controller;

import com.minghai.domain.Account;
import com.minghai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("执行了。。。。"+username);
        return "success";
    }

    /**
     * 请求参数封装，把数据封装到JavaBean
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String savaAccount(Account account){
        System.out.println(account);
        return "success";
    }
    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String savaUser(User user){
        System.out.println(user);
        return "success";
    }
    /**
     * 原生的ServletAPI
     * @param user
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);

        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        return "success";
    }
}
