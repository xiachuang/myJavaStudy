package cn.hdj.test;

public class SubClass  {
    //pulbic final void test(){}
    public static void main(String[] args) {
        SubClass test = new BassClass();//子类---//父类对象不能调用子类方法
        test.test();
    }
    private  void test(){
        System.out.println("父类");
    }
}

class BassClass extends SubClass {
    public void test(){
        System.out.println("子类");
    }
    public void test1(){
        System.out.println("1类");
    }

}