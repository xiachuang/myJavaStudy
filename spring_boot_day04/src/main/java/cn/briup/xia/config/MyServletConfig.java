package cn.briup.xia.config;

import cn.briup.xia.filter.MyFilter;
import cn.briup.xia.listener.MyListener;
import cn.briup.xia.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class MyServletConfig {
    //注册组件
    //各类属性都可以在 registrationBean 中设置
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean MyListener(){
      ServletListenerRegistrationBean<cn.briup.xia.listener.MyListener>  registrationBean= new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return registrationBean;
    }
}
