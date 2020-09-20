package cn.briup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    private final  String PEX="pages/";
    @RequestMapping("/userLogin")
    public String login(){
        return PEX+"login";
    }
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path")String path){
        return PEX+"/level1/"+path;
    }
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path")String path){
        return PEX+"/level2/"+path;
    }
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path")String path){
        return PEX+"/level3/"+path;
    }
}
