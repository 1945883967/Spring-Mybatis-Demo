package com.minghai.controller;

import com.minghai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/testString")
    public String testString(Model model){
        System.out.println("testString方法执行l....");
        // 模拟从数据库查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        // model 对象
        model.addAttribute("user",user);
        return "success";
    }


    /**
     *
     *  请求转发一次请求，不用写项目名字
     */
    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了....");

//        // 编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

//        // 重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");


        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接会进行响应
        response.getWriter().print("hello 明海");
        return;
    }

    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        System.out.println("testModelAndView方法执行了....");
        User user = new User();
        user.setUsername("美美");
        user.setPassword("1234");
        user.setAge(25);

        // 把user对象存储到mv独享中，也会把user对象存储到request域中
        mv.addObject("user",user);


        // 跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testFordwordOrRedirect")
    public String testFordwordOrRedirect(){
        System.out.println("testFordwordOrRedirect");

        // 请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 作响应，模拟查询数据库
        user.setUsername("minghai");
        user.setAge(22);
        // 做响应
        return user;
    }

}
