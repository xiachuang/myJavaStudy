package cn.hdj.th;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExThTest {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(3);//线程池
        MyRunnable runnable=new MyRunnable();
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        for (int i=0;i<5;i++){
            System.out.println(" :"+i);

        }
    }
}
