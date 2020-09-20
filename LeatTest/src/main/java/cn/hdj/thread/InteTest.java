package cn.hdj.thread;

public class InteTest {
    public static void main(String[] args) {
        Thread r1=new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<10;i++){
                System.out.println(i+"--->");
            }
        });
        try {
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r1.start();
        System.out.println(r1.getState());
        r1.interrupt();//将阻塞进程变为就绪
        System.out.println(r1.getState());
    }
}
