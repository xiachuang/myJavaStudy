package cn.jp.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Refet {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class clazz=Person.class;
        Constructor con= clazz.getConstructor(int.class,String.class);
       Object b= con.newInstance(1,"xiachuang");
       Person p=(Person)b;
        System.out.println(p.toString());

        Method me=clazz.getDeclaredMethod("show1", int.class);
        me.setAccessible(true);
        me.invoke(p,2);//两种方式都可以
        Method me1= clazz.getMethod("show", String.class);
        me1.invoke(clazz.newInstance(),"下厨房");
    }
}
