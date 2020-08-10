package cn.hdj.ssm.web;

import cn.hdj.ssm.domain.UserInfo;
import cn.hdj.ssm.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService ius;
    @RequestMapping("/findByid.do")
    public ModelAndView findByid(Integer id){
        UserInfo userInfo=ius.findUserById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return  mv;
    }
    @RequestMapping("/save.do")
    public  String save(UserInfo userInfo){
       Boolean bl= ius.save(userInfo);
        System.out.println(bl);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<UserInfo>  list= ius.findByAll();
        mv.addObject("userList",list);
        mv.setViewName("uesr-list");
        return  mv;
    }
}
