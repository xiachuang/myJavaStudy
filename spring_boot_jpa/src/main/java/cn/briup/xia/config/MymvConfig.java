package cn.briup.xia.config;

import cn.briup.xia.component.LoginHandlerInterceptor;
import cn.briup.xia.component.MyLocalResolve;
import cn.briup.xia.component.MyLocalResolve;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
//扩展Springmvc的功能
//自己配置自动加载功能
//@EnableWebMvc  全面接管Springmvc 的配置  不用springboot自动配置的
//0b 二进制  0开头 二进制 0x十六进制
@Configuration
public class MymvConfig implements WebMvcConfigurer {
    //自定义servlet 配置
    //@Bean
//    public EmbeddedWebServerFactoryCustomizerAutoConfiguration embeddedWebServerFactoryCustomizerAutoConfiguration(){
//        return new EmbeddedWebServerFactoryCustomizerAutoConfiguration(){
//
//        };
//    }

    //-------------------------------------
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/briup请求直接跳到success页面
        registry.addViewController("/briup").setViewName("index");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer wmcf=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/main.html").setViewName("main");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //设置拦截的路径  和忽略的拦截的路径
                //静态资源 SpringBoot 不用处理
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/xia/**")
                        .excludePathPatterns("/login","/","/user/login","/main","/hello","/login.html","/index","/hello1");
            }
        };
        return wmcf;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return   new MyLocalResolve();
    }


}
