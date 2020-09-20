package cn.briup.xia.Controller;

import cn.briup.xia.exception.UserNotExitException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user")String user){
        if(user.equals("aaa")){
            throw new UserNotExitException();
        }
        return "hello 夏创";
    }

//
    @RequestMapping("/map")
    public  @ResponseBody Map<String,Object>   map1(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","夏创");
        map.put("age",18);
        map.put("happy","篮球");
        return map;
    }
    @RequestMapping("/thTest")
    public ModelAndView teTest(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("name","夏创");
        map.put("user", Arrays.asList("肖响","夏曦瑶","乔峰","龙文章"));
        mv.addObject("maps",map);
        mv.setViewName("success");
        return mv;
    }
}
