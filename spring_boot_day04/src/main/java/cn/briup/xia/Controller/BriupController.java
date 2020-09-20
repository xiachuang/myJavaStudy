package cn.briup.xia.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class BriupController {
    @RequestMapping({"/login","/login.html"})
    public String index(){
        return "login";
    }
    @RequestMapping("/success2")
    public ModelAndView success(Map<String,Object> map){
        map.put("hello","夏创");
        map.put("age",16);
        map.put("grade","初三");
        ModelAndView mv=new ModelAndView();
        mv.addObject("map",map);
        mv.setViewName("success2");
        return mv;
    }
    @RequestMapping("/test02")
    public String test02(HttpServletRequest request, HttpServletResponse response){
            request.setAttribute("msg","Yes");
            return "success3";
            }
}
