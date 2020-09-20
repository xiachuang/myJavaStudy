package cp;

public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread r1=new Thread(()->{
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for(int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + "启动了！！");
            }
        },"hex");
        Thread r2= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    System.out.println(Thread.currentThread().getName() + "启动了！！");
                }
            }
        });

        r1.start();
        r2.start();
    }
}
