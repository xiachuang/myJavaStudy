package cn.briup.jpas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class GetStartController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/end")
    @ResponseBody
    public String startMq(String name) {
        String s = restTemplate.getForObject("http://RABBOTMQ-GET/start", String.class);
        return name + "8081" + s;
    }
}
