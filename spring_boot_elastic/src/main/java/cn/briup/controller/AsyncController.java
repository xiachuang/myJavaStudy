package cn.briup.controller;

import cn.briup.async.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    private Play play;
    @RequestMapping("/hello")
    public String hello(){
        play.play2();//异步
        return "hello world";
    }
}
