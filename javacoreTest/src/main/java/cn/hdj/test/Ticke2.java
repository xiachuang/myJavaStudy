package cn.hdj.test;

public class Ticke2 implements Runnable {
    int tick=100;
    Object lock=new Object();
    @Override
    public  void run() {
        while (true) {
            try {
                method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void method() throws InterruptedException {
        if(tick>0){
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName()+"正在买票"+tick);
            tick--;
        }
    }
}
