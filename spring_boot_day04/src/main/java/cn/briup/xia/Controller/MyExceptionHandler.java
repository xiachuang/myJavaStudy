package cn.briup.xia.Controller;

import cn.briup.xia.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常处理器 注解
@ControllerAdvice
public class MyExceptionHandler {
//    @ResponseBody
    @ExceptionHandler(UserNotExitException.class)
    public String handlerexception(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notextist");
        map.put("message","错误！！！！！！！！！！");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);//0表示从何处获取
//        return map;
        return "forward:/error";
    }
}
