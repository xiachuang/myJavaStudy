package cn.briup.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class MySecurity2Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/*").permitAll()
                .antMatchers("/druid/*").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
              .antMatchers("/access").access("hasRole('VIP3')")
             .antMatchers("/user/**").hasAnyRole("VIP1","VIP2","VIP3");
            http.formLogin()
                    .usernameParameter("user")
                    .passwordParameter("pwd")
                    .loginPage("/userLogin");//指定登录页面 默认post方式的/logi
            http.logout().logoutSuccessUrl("/");
         http.rememberMe().rememberMeParameter("remember");
         /*
         anyRequest().authenticated()  //anyRequest表示其他任何请求，authenticated表示需要认证
                .and() //过渡作用，返回一个对象（与http.authorizeRequests()返回的对象相同）
          */
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        super.configure(auth);
//    }
}
