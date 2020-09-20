package cp;
//线程优先级
public class ThreadTest02 {
    public static void main(String[] args) {
      Thread r1=new Thread(()->{
          for(int i=0;i<10;i++) {
              System.out.println(Thread.currentThread().getName() + "----1----");
          }
      });
      Thread r2=new Thread(()->{
          for(int i=0;i<10;i++) {
              System.out.println(Thread.currentThread().getName() + "---2----");
          }
      });
      r1.setPriority(1);
      r2.setPriority(10);
//      r1.setPriority(Thread.MAX_PRIORITY);//默认为10
//        // r2.setPriority(Thread.MIN_PRIORITY);//默认5
//        r1.setPriority(Thread.NORM_PRIORITY);//默认5
      r1.start();
      r2.start();
    }
    public static void test(Lab lab){
        test(()->{
            System.out.println("hello world");
        });
    }
    /*
        可以设置线程所在的线程组
        ThreadGroup group = new ThreadGroup("我的线程组");
        //指定线程所属的线程组 Thread t = new Thread(group,"t线程");
     */


}
