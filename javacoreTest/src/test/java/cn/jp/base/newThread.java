package cn.jp.base;

public class newThread implements Runnable {
    //定义公平锁 用来实现线程交替执行
   // ReentrantLock lock=new ReentrantLock();
    int i=0;
    @Override
    public synchronized void run() {
        while(i<100){
            i++;
            if(i%2==0){
                notifyAll();
                System.out.println(Thread.currentThread().getName()+" "+i);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                notifyAll();
                System.out.println(Thread.currentThread().getName()+" "+i);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
