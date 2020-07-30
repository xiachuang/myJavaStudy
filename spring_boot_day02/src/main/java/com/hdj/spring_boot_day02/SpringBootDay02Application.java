package com.hdj.spring_boot_day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
//加载配置 指定的配置文件
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootDay02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDay02Application.class, args);
    }

}
