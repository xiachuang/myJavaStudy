package cn.jp.base.day3;

import cn.jp.base.newThread;
import cn.jp.base.newThread1;
import org.junit.Test;
public class Test02  {
    @Test
    public void test02(){
        newThread nt=new newThread();
        Thread t1=new Thread(nt,"A");
        Thread t2=new Thread(nt,"B");
        t1.start();
        t2.start();
    }
    @Test
    public void test03(){
        newThread1 nt=new newThread1();
        Thread t1=new Thread(nt,"A");
        Thread t2=new Thread(nt,"B");
        t1.start();
        t2.start();
    }
}
