package com.hdj.spring_boot_day02;

import com.hdj.spring_boot_day02.domain.Car;
import com.hdj.spring_boot_day02.domain.Person;
import com.hdj.spring_boot_day02.domain.User;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class SpringBootDay02ApplicationTests {
    @Autowired
    Person person;
    @Autowired
    User user;
    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(person);
    }
    @Test
    public  void test01(){
        System.out.println(user);
    }
    @Value("${person.person-name}")
    private String name;
    @Test
    public void test03(){
        System.out.println("  "+name);
    }
    @Test
    public void testhelloservice(){
        boolean b=ioc.containsBean("helloService");
        System.out.println(b);
    }
    @Test
    public  void testCar(){
      Car b= (Car)ioc.getBean("car");
        System.out.println(b);
    }
//    @Test
//    public void testperson(){
//      Person b= (Person) ioc.getBean("person");
//        System.out.println(b);
//    }
}
