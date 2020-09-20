package cn.briup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好世界");
        return "success";
    }
}
