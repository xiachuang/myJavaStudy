package cn.hdj.accent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BCC {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        Thread r=new Thread(()->{
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  Ïß³Ì³Ø");
        });
        r.interrupt();
        service.submit(r);
        service.submit(r);
        service.shutdown();
    }
}
