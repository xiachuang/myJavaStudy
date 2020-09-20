//package cn.briup.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()//放行
//                .antMatchers("/level1/**").hasRole("VIP1")//添加角色权限
//                .antMatchers("/level2/**").hasRole("VIP2")
//                .antMatchers("/level3/**").hasRole("VIP3");
//        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
//        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userLogin");
//        //1、/login来到登陆页
//        //2、重定向到/login?error表示登陆失败
//        //3、更多详细规定
//        //4、默认post形式的 /login代表处理登陆
//        //5、一但定制loginPage；那么 loginPage的post请求就是登陆
//
//        //开启注销功能
//        http.logout().logoutSuccessUrl("/");//注销后回到首页
//        //开启记住我功能
//        http.rememberMe().rememberMeParameter("remember");
//        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
//        //点击注销会删除cookie
//    }
//
//    @Override
//    //定义认证规则
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        String pwd="123456";
////        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
////        String pwd2=passwordEncoder.encode(pwd);
//       auth.inMemoryAuthentication()
//              .passwordEncoder(new BCryptPasswordEncoder())
//               .withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2");
//       auth.inMemoryAuthentication()
//               .passwordEncoder(new BCryptPasswordEncoder())
//               .withUser("user2").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user3").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3");
//
//    }
//}
