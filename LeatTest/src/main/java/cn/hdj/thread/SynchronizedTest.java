package cn.hdj.thread;

public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest test=new SynchronizedTest();
        SynchronizedTest test1=new SynchronizedTest();
        Thread r1=new Thread(()->{
//            try {
//            Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            test.show();
        });
        r1.setName("A");

        Thread r2=new Thread(()->{
            test.show();
        });
        r2.setName("B");
        r1.start();
        r2.start();

    }
    public synchronized void show(){  //锁对象要相同
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"  ="+i);
        }
    }







//    public static void main(String[] args) {
//        Thread r1=new Thread(()->{
//           synchronized (Object.class){
//               for(int i=0;i<20;i++){
//                   System.out.println(Thread.currentThread().getName()+"  "+i);
//               }
//           }
//        });
//        r1.setName("A");
//        Thread r2=new Thread(()->{
//            synchronized (Object.class){
//                for(int i=0;i<20;i++){
//                    System.out.println(Thread.currentThread().getName()+"  "+i);
//                }
//            }
//        });
//        r2.setName("B");
//        r1.start();
//        r2.start();
//    }


//    public static void main(String[] args) {  线程不安全
//        int[] arr = new int[10];
//
//        Thread r1 = new Thread(() -> {
//
//            for (int i = 0; i < 10; i++) {
//                arr[i] = i;
//            }
//            System.out.println(Arrays.toString(arr));
//        });
//        Thread r2 = new Thread(() -> {
//            int[] arr1=new int[arr.length*2];
//            for (int i = 1; i < arr.length*2-1; i++) {
//                arr1[i] = i;
//            }
//            System.out.println(Arrays.toString(arr));
//        });
//        r1.start();
//        r2.start();
//    }
}
