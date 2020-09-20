package cn.jp.base.thread;

public class NewThread01 implements Runnable {
    int i=0;
    @Override
    public void run() {

        synchronized (this){
                while (i<70){
                    i++;
                    if(i%2==0){
                        notify();//提醒等待线程准备抢占CPU
                        System.out.println(Thread.currentThread().getName()+" "+i);
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        notify();
                    }else {
                        notify();
                        System.out.println(Thread.currentThread().getName()+" "+i);
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    notify();//结束
                }
        }
    }
}
