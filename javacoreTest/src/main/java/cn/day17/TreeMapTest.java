package cn.day17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreeMapTest {
    private  final static  int num=100;
    private static String  name;
    private Long cc;

    @Override
    public String toString() {
        return "TreeMapTest{" +
                "cc=" + cc +
                '}';
    }

    public static void main(String[] args) {
        Thread();
    }
    public static void Thread(){
        ExecutorService service= Executors.newFixedThreadPool(2);
        Thread r=new Thread(()->{
            System.out.println("启动了-----------------");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"success-----------------");
        });
        service.submit(r);
        service.submit(r);
        service.submit(r);

    }
}
