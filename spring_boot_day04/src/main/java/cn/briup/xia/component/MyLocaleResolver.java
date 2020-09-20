package cn.briup.xia.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
    国际化
    在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l=request.getParameter("l");
        Locale local=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
           String[] split= l.split("_");
            local=new Locale(split[0],split[1]);
        }
//        第二种写法
//        request.getParameter("l");//l 页面传的参数
//        if(StringUtils.isEmpty()){
//            return  request.getLocale();
//        }else{
//            String[] split=l.split("_");
//          return   new Locale(split[0],split[1]);
//        }
        return local;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
