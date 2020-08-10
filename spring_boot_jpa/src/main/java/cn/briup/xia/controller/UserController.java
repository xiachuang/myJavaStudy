package cn.briup.xia.controller;

import cn.briup.xia.baen.User;
import cn.briup.xia.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService us;
    //查询不到  至为空  JPA
    @PostMapping("/user/login")
    public ModelAndView login(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword, HttpSession session){
         String password  = us.checkUserName(userName);
         ModelAndView mv=new ModelAndView();
         if(password==null){
             mv.addObject("msg","用户不存在！");
             mv.setViewName("/login");
             return  mv;
         }else  if(password.equals(userPassword)){
            System.out.println("login .....");
            session.setAttribute("loginUser",userName);
            mv.addObject("userName",userName);
            mv.setViewName("redirect:/main.html");
            return mv;
        }else{
            System.out.println("false");
            mv.addObject("msg","用户或密码错误！");
            mv.setViewName("/login");
            return  mv;
        }
    }
    //点击按钮 携带账户
    @RequestMapping("/update")
    public ModelAndView updatePwd(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword,@RequestParam("userpwd")String userpwd) {
        ModelAndView mv = new ModelAndView();
            if (userPassword.equals(userpwd)) {
             us.updateUserPwd(userName, userPassword);
                mv.setViewName("/login");
                return mv;
            } else {
                mv.addObject("msg", "两次密码不相同请再次输入");
                mv.setViewName("/repe");
                return mv;
            }
        }
     @PostMapping("/register")
    public String registerUser(User user){
            us.insertUser(user);
            return "redirect:/index.html";
        }

    }
