package cn.hdj.th;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" :"+i);

        }
        return null;
    }
}
