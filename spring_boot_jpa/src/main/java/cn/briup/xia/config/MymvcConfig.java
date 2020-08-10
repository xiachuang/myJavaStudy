package cn.briup.xia.config;

import cn.briup.xia.component.LoginHandlerInterceptor;
import cn.briup.xia.component.MyLocalResolve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MymvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
    WebMvcConfigurer wmcf=new WebMvcConfigurer() {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/main.html").setViewName("main");
            registry.addViewController("/index.html").setViewName("login");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/main.html","index");
        }
    };
    return wmcf;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolve();
    }
}
