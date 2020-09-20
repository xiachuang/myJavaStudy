package cn.jp.base2;
import  org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class RefectTest01 {
    //反射类的基本用法1
    @Test
    public void test01(){
        Student student=new Student();
        Class c=student.getClass();
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        System.out.println(c.getPackage().getName());
        System.out.println(c.getSuperclass().getName());
        Class c2=Object.class;
        //判断c2代表的类型是不是c代表类型 的父类型
        System.out.println(c2.isAssignableFrom(c));

    }
    //获取属性
    @Test
    public  void test02() throws Exception {
        Class c1=Student.class;
        Class c=Class.forName("cn.jp.base2.Student");
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            System.out.println("修饰符"+ Modifier.toString(field.getModifiers())+"-->类型"+field.getType().getName()
            +"-->属性名称"+field.getName()+"  ");
        }
        System.out.println("----------------------------------");
        Field[] fields1=c.getFields();//可以获取从父类中得到的属性
        for(Field field:fields1){
            System.out.println("修饰符"+ Modifier.toString(field.getModifiers())+"-->类型"+field.getType().getName()
                    +"-->属性名称"+field.getName()+"  ");
        }
    }
    //获取方法
    @Test
    public void test03() throws Exception{
        Class c=Class.forName("cn.jp.base2.Student");
        Method[] methods=c.getDeclaredMethods();
        for(Method method:methods){
            System.out.println("修饰符"+Modifier.toString(method.getModifiers())+"--->返回值"+method.getReturnType().getSimpleName()
            +"--->方法名"+method.getName()+"--->参数个数"+method.getParameterCount());
            Class[] param=method.getParameterTypes();
            System.out.println("方法的参数列表"+ Arrays.toString(param));
            System.out.println("---------------------------->");
        }
        Method[] method=c.getMethods();//可以获得不包括私有和默认的父类和子类方法
        for(Method method1:method){
            System.out.println("方法名"+method1.getName()+"修饰符"+Modifier.toString(method1.getModifiers()));
        }
    }
    //构造器的获取
    @Test
    public void test04() throws Exception{
        Class c=Class.forName("cn.jp.base2.Student");
         Constructor[] constructors= c.getDeclaredConstructors();
         for(Constructor constructor:constructors){
             System.out.println("名"+constructor.getName()+"-->修饰符"+Modifier.toString(constructor.getModifiers())
             +"--->参数个数"+constructor.getParameterCount());
             Class[] param=constructor.getParameterTypes();
             System.out.println(Arrays.toString(param));
         }
         Constructor[] constructors1=c.getConstructors();
         for(Constructor constructor:constructors1){
             System.out.print(constructor.getName()+"----");
         }
    }
    //访问属性
    @Test
    public void Test05() throws Exception{
        Class c=Class.forName("cn.jp.base2.Student");
        Student student=new Student();
        Field f=c.getDeclaredField("age");
        f.setAccessible(true);
        f.set(student,18);
        System.out.println(f.get(student));
        Field f1=c.getField("name");
        f1.set(student,"夏创");
        System.out.println(f1.get(student));
        Field f2=c.getDeclaredField("idCard");//静态方法
        f2.setAccessible(true);
        f2.set(null,10001);
        System.out.println(f2.get(null));
    }
    //反射调用方法
    @Test
    public void test06() throws Exception{
        Class c=Class.forName("cn.jp.base2.Student");
        Student student=new Student();
        Method method=c.getDeclaredMethod("show3", String.class);
        method.setAccessible(true);//开启私有访问
        method.invoke(student,"夏创");
        Method method1=c.getMethod("show",Integer.class,String.class);
        method1.invoke(student,2,"肖响");
    }
    //反射创键对象
    @Test
    public void test07() throws Exception{
        Class<Student> c= (Class<Student>) Class.forName("cn.jp.base2.Student");
       Student student= c.newInstance();
       Method method=c.getDeclaredMethod("show3", String.class);
       method.setAccessible(true);
       method.invoke(student,"夏创");
       Constructor<Student> constructor=c.getDeclaredConstructor(Integer.class,String.class);
       constructor.setAccessible(true);
       Student obj= constructor.newInstance(1001,"xiachuang");
        System.out.println(obj.toString());
    }
}
