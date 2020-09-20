package cn.briup.controller;

import cn.briup.bean.User;
import cn.briup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/insertUser")
    public ModelAndView  insertUser(User user){
        ModelAndView mv=new ModelAndView();
        if(user!=null){
            userService.insertUser(user);
            mv.addObject("msg","注册成功！！");
            mv.setViewName("redirect:/");
            return mv;
        }else{
            mv.setViewName("redirect:/");
            return mv;
        }
    }
}
