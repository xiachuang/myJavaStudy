package cn.hdj.th;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExCall {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        MyCallable call=new MyCallable();
        service.submit(call);
        service.submit(call);
        for(int i=0;i<5;i++){
            System.out.println("QQQ"+" :"+i);
        }

    }

}
