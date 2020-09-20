package cn.hdj.th;

public class Thread01 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" :"+i);
        }
    }
}
