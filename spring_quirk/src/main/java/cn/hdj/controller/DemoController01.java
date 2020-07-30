package cn.hdj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController01 {
    @RequestMapping("/quick")
    @ResponseBody
    public  String quick(){
    return  "ni hao  springboot";
    }
}
