package cn.hdj.test;

public class MyTicker  {
    public static void main(String[] args) {
        Ticke t=new Ticke();
        Thread t1=new Thread(t,"A窗口");
        Thread t2=new Thread(t,"B窗口");
        Thread t3=new Thread(t,"C窗口");
        t2.start();
        t1.start();

        t3.start();
    }
}
