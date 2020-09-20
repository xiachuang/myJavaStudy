package cn.briup.service;

import cn.briup.Person;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
    public class PersonService {
//    @RabbitListener(queues = "briup")
//    public void getQueues(Person person){
//        System.out.println("success.....");
//        System.out.println("收到信息"+person);
//    }

//    @RabbitListener(queues = "briup")
//    public  void getMessage(Message message){
//        System.out.println(message.getBody());
//        System.out.println(message.getMessageProperties());
//    }
    @RabbitListener(queues = "briup.news")
    public void getBriup(Person person){
        System.out.println(person);
    }
//    ------------------------------------------------------
//创建 交换机 绑定关系  消息队列

}
