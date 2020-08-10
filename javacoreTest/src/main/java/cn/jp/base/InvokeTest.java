package cn.jp.base;


//反射机制  调用方法
public class InvokeTest {
    public static void main(String[] args) throws Exception {
//        Class<?> clazz=Class.forName("cn.jp.base.InvokeTest");
//        Method md= clazz.getMethod("invoke", int.class, String.class);
//        md.invoke(clazz.newInstance(),23,"夏创");
            Class<?> clazz=Class.forName("cn.jp.base.Person");
            clazz.getConstructor();

    }
    public  void invoke(int i,String name){
        System.out.println(i+"    "+name);
    }
}
