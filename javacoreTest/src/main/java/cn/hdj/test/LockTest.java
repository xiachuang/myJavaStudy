package cn.hdj.test;

public class LockTest {
    //lock 锁控制 同步代码块
    public static void main(String[] args) {
       ThreadLock lock=new ThreadLock();
        Thread t1=new Thread(lock,"A");
        Thread t2=new Thread(lock,"B");
        t1.start();
        t2.start();
    }
}
