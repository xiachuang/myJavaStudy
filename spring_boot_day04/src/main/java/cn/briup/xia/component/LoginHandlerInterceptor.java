package cn.briup.xia.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginHandlerInterceptor implements HandlerInterceptor {


    @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
//            Map<String,Object> map=new HashMap<>();
//            map.put("msg","没有权限请登入");
            request.setAttribute("msg", "没有权限请登入");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        } else {
            //放行

            return true;
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
