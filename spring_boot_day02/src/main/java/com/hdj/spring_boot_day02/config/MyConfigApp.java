package com.hdj.spring_boot_day02.config;



import com.hdj.spring_boot_day02.domain.Car;


import com.hdj.spring_boot_day02.domain.Person;
import com.hdj.spring_boot_day02.servie.HelloService;
import com.hdj.spring_boot_day02.servie.helloSpringCar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//替代  spring 配置文件
@Configuration
public class MyConfigApp  {
   //将方法的 的返回值 添加倒容器
    @Bean
    public HelloService helloService(){
        System.out.println("success");
    return new HelloService();

   }
    @Bean
    public helloSpringCar helloSpringCar1(){
        return new helloSpringCar();
    }

    @Bean
    public  Car car(){
        System.out.println("car......run....");
        return  new Car();
    }
//    @Bean
//    public Person person(){
//        System.out.println("car.....run....");
//        return  new Person();
//    }

}
