package cn.briup.xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/hello")
    public String login(){
        System.out.println("login");
        return  "login";
    }
    @RequestMapping("/hello1")
    public String login1(){
        System.out.println("login");
        return  "index";
    }
}
