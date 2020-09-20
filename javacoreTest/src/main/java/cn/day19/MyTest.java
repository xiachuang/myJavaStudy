package cn.day19;

public class MyTest {
    public static void main(String[] args) {
//        test();
        test1();
    }
    public static void   test(){
        try{
            double b=10/0;
        }catch (MyException e){
            e.printStackTrace();
        }finally {
            System.out.println("自定义异常启动！！！");
        }
    }
    public static void   test1(){
       int a=10;
       int b=18;
       if(b>a){
           throw new MyException("自定义异常启动！！！");
       }
    }
}
