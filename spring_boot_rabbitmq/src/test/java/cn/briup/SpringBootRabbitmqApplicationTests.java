package cn.briup;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class SpringBootRabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
    }
    @Test
    public  void creatDirect(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","相处啊个");
        map.put("age",12);
        map.put("list", Arrays.asList("hello",23,true));
        System.out.println("-------------------->");
        rabbitTemplate.convertAndSend("exchange.direct","briup.news",map);

    }
    @Test
    public void getDirect(){
     Person person= (Person)rabbitTemplate.receiveAndConvert("briup.news");
        System.out.println(person);
    }
    //广播
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Person(100, "夏创",23));
    }
    //topic
    @Test
    public void sendTopic(){
    rabbitTemplate.convertAndSend("exchange.topic","da.news",new Person(1001,"肖响",22));
    }
    @Test
    public void sendTopic1(){
        rabbitTemplate.convertAndSend("exchange.topic","briup.sda",new Person(1002,"蒋玄",23));
    }
    @Test
    public void  sendDirect(){
        rabbitTemplate.convertAndSend("exchange.direct","briup",new Person(1,"夏雨",23));
    }
    @Test
    public void setExchange(){
        //创建交换机
//        amqpAdmin.declareExchange(new DirectExchange("hdjd.fanout"));
//        System.out.println("创建成功");
        amqpAdmin.declareQueue(new Queue("huaYu"));
        //创建绑定关系
        amqpAdmin.declareBinding(new Binding("huaYu",Binding.DestinationType.QUEUE,"hdjd.direct","yuaYu.lili",null));
        System.out.println("创建成功");
    }
    @Test
    public void sendHdjd(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","肖响");
        map.put("name2","夏曦瑶");
        map.put("yu","史上安得双全法，不负如来不负卿");
        rabbitTemplate.convertAndSend("hdjd.direct","yuaYu.lili",map);
    }
    @Test
    public void getHuaYu(){
     Map<String,Object> map= (Map<String, Object>) rabbitTemplate.receiveAndConvert("huaYu");
        System.out.println(map.get("name"));
    }
}
