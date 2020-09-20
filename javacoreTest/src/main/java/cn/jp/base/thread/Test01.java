package cn.jp.base.thread;

public class Test01 {
    public static void main(String[] args) {
        NewThread01 nt = new NewThread01();

        Thread t1 = new Thread(nt, "A");
        Thread t2 = new Thread(nt, "B");
        t1.start();
        t2.start();
        return;
    }
}