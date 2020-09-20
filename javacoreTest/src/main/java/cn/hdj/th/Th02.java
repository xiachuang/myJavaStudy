package cn.hdj.th;

public class Th02 {
    public static void main(String[] args) {

        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName()+" :"+i);

                }
            }
        };
        Thread r1=new Thread(r,"AAA");
        Thread r2=new Thread(r,"CCC");
        r1.start();
        r2.start();
        for (int i=0;i<5;i++){
            System.out.println("A"+i);

        }

    }
}
