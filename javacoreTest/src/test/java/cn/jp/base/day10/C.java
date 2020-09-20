package cn.jp.base.day10;
public class C {
    public  static  void  main(String[]  args)  {
        A a  =  new  B();
        B  b  =  new  B();
        B  b1  =  (B)a;
        System.out.println("Result="  +  a.func1(100,  50));
        System.out.println("Result="  +  b.func1(100,  50));
      System.out.println("Result="  +  a.test1(100));
        System.out.println("Result="  +  b.test1(100));
        System.out.println("Result="  +  b1.test1(100));
    }
}
