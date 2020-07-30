package com.hdj.spring_boot_day02.controller;

import com.hdj.spring_boot_day02.domain.Person;
import com.hdj.spring_boot_day02.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @Value("${person.person-name}")
    private  String name;
    //@Autowired
    private Person person;
    @RequestMapping("/hello")
    public String    hello(){
        return name;
    }
}
