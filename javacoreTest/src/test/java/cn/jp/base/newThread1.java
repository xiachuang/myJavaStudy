package cn.jp.base;

public class newThread1 implements Runnable {
    int i=0;
    @Override
    public void run() {
        synchronized (this){
            while (i<100){
                i++;
                if(i%2==0){
                    notify();
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    notify();
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
