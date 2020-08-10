package cn.briup.xia.config;

import cn.briup.xia.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常处理注解
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MyException.class)
    public String handelSelectOrSave(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","select_save_error");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "redirect:/error";
    }
}
