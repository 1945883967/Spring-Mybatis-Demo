package com.minghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileUpload1(){
        System.out.println("文件上传");
        return "success";
    }
}
