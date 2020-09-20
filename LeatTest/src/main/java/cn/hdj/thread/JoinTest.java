package cn.hdj.thread;

public class JoinTest {
    public int c=0;
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread r1=new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + "   " +i);
                System.out.println(new JoinTest().c);
            }
        });
        Thread r2=new Thread(new Runnable() {


            @Override
            public void run() {
                try {
                    r1.join();//等到 r1 运行结束才执行r2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                }
            }
        });
        r2.start();
        r1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r2.getState());
    }
}
