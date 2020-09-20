package cn.hdj.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDenoSy {

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        ThreakLock tk=new ThreakLock();
        service.submit(tk);
        service.submit(tk);
    }
}
