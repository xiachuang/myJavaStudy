package cn.briup.xia.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;


import java.util.Map;

//给容器中加入自己定制的错误属性
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回的map就是页面中的json数据
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
     Map<String, Object>  map= super.getErrorAttributes(webRequest, options);
     map.put("briup","xia");
     //异常处理 器中的数据
    Map<String,Object> ext=(Map<String, Object>) webRequest.getAttribute("ext",0);//scope表示从何处获取 0表示request中
    map.put("ext",ext);
        return map;

    }
}
