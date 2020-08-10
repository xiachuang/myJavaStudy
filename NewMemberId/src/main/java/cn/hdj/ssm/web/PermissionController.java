package cn.hdj.ssm.web;

import cn.hdj.ssm.domain.Permission;
import cn.hdj.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService ips;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
       List<Permission> list= ips.findByAll();
       mv.addObject("permissionList",list);
       mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
        Boolean bl=ips.save(permission);
        System.out.println(bl);
        return "redirect: findAll.do";
    }
}
