package cn.hdj.ssm.web;

import cn.hdj.ssm.domain.Role;
import cn.hdj.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("/role")
public class RoleController {
    @Autowired
    private IRoleService irs;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Role> list=irs.findByAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("roleList",list);
        mv.setViewName("role-list");
        return  mv;
    }
    @RequestMapping("/save")
    public  ModelAndView save(Role role){
        ModelAndView mv=new ModelAndView();
        Boolean bl=irs.save(role);
        mv.setViewName("redirect:findAll.do");
        return mv;
    }
}
