package cn.briup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@MapperScan(value = "cn.briup.mapper")
@EnableCaching
public class SpringBootSecurityApplication {
    /**
     * 1、引入SpringSecurity；
     * 2、编写SpringSecurity的配置类；
     * 		@EnableWebSecurity   extends WebSecurityConfigurerAdapter
     * 3、控制请求的访问权限：
     * 		configure(HttpSecurity http) {
     * 		 	http.authorizeRequests().antMatchers("/").permitAll()
     * 		 		.antMatchers("/level1/**").hasRole("VIP1")
     * 		}
     * 4、定义认证规则：
     * 		configure(AuthenticationManagerBuilder auth){
     * 		 	auth.inMemoryAuthentication()
     * 		 		.withUser("zhangsan").password("123456").roles("VIP1","VIP2")
     * 		}
     * 5、开启自动配置的登陆功能：
     * 		configure(HttpSecurity http){
     * 		 	http.formLogin();
     * 		}
     * 6、注销：http.logout();
     * 7、记住我：Remeberme()；
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

}