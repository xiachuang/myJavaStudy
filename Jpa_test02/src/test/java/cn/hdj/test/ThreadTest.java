package cn.hdj.test;
import org.junit.Test;
public class ThreadTest {
    Boolean bl=false;
    @Test
    public void th() {
        Object lock=new Object();
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                int n=30;
                while(n!=0){
                    synchronized (lock){
                        try {
                            Thread.sleep(500);
                            System.out.println(Thread.currentThread().getName()+":"+"运行了");
                            bl=true;
                            lock.notifyAll();
                            n--;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName()+" "+"---");
                        if(bl!=true){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        bl=false;
                    }
                }
            }
        });
        System.out.println("开始！！");
        threadA.setName("A:");
        threadA.start();
        threadB.setName("B:");
        threadB.start();
    }
}
