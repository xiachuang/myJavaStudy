package cn.briup.xia.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
//    @GetMapping
//    @PutMapping
//    @DeleteMapping
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)//method 限定请求的提交方式=@PostMapping
    public ModelAndView login(@RequestParam("username")String username, @RequestParam("password")String password, Map<String,Object> map, HttpSession session, Model model){
        ModelAndView mv=new ModelAndView();
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            System.out.println("success");
            session.setAttribute("loginUser",username);
//            session.setAttribute("username",username);
            mv.addObject("username",username);
            mv.setViewName("redirect:/main.html");
            return mv;
        //   model.addAttribute("username",username);
          //  return "redirect:/main.html";
            //重定向写法 return "redirect:/main.html
        }else {
            System.out.println("false");
//            map.put("msg","用户或密码错误");
            mv.addObject("msg","用户或密码错误");
            mv.setViewName("/login");
//            model.addAttribute("map",map);
            return  mv;
          //  return "login";
        }
//     转发的写法   public  String login(@RequestParam("username")String username, @RequestParam("password")String password, Map<String,Object> map, Model model){
//            if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
//                System.out.println("success");
//                map.put("username",username);
//                model.addAttribute("map",map);
//                return "zhuye";
//            }else {
//
//                map.put("msg","用户或密码错误");
//
//                model.addAttribute("map",map);
//                return "login";
//            }

    }
}
