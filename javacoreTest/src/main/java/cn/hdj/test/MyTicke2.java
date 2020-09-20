package cn.hdj.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTicke2 {

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        Ticke2 t2=new Ticke2();
        service.submit(t2);
        service.submit(t2);
    }

}
