package cn.hdj.thread;

public class A {
    public A(int i){
        System.out.println(i);
    }
}
class  B{
    public B(){
        System.out.println("he");
         a=new A(2);
    }
    A a=new A(4);
    void fun(){
        System.out.println("fun");
    }
    public static void main(String[] args) {
        B b=new B();
        b.fun();
    }
}
