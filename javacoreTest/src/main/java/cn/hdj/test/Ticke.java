package cn.hdj.test;

public class Ticke implements Runnable {
    int ticke=100;
    Object lock=new Object();
    @Override
    public void run() {
        while(true){
            synchronized (lock){//同步代码块

                if(ticke>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" 正在卖出 :"+ticke);
                    ticke--;
                }
            }
        }
    }
}
