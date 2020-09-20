package cn.hdj.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock implements Runnable{
    Lock ck=new ReentrantLock();//lock锁的作用
    int tick=100;
    @Override
    public void run() {
    while (true){
        ck.lock();
        if(tick>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在买票"+tick);
            tick--;
        }
        ck.unlock();
    }
    }
}
