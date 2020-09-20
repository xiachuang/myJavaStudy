package cn.briup.async;
//异步方法

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Play {
    @Async//完成异步操作 需要加到容器中才有效
    public void play2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("一起去田野玩");
    }
}
