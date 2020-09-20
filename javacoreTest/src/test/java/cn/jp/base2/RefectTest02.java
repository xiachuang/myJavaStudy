package cn.jp.base2;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefectTest02 {
    @Test
    public void test02() throws Exception {
        Class<Student> c = (Class<Student>) Class.forName("cn.jp.base2.Student");
        Student student = c.newInstance();
        Method method = c.getMethod("show", Integer.class, String.class);
        method.invoke(student, 1001, "夏创");
        Student student1 = c.newInstance();
        student1.setAge(19);
        student1.setAddress("南极");
        Method method1 = c.getDeclaredMethod("showSt", Student.class);
        method1.setAccessible(true);
        method1.invoke(student, student1);
        Method method2 = c.getDeclaredMethod("show1", String.class);
        method2.setAccessible(true);
        method2.invoke(student, "肖下");

    }

    @Test
    public void test03() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Class<Student> c = (Class<Student>) Class.forName("cn.jp.base2.Student");
        Student student = c.newInstance();
        Method method = c.getMethod("showSchool", String.class);
        method.invoke(student, "炫动");
    }

    @Test
    public void test04() throws Exception {
        Class<Student> c = (Class<Student>) Class.forName("cn.jp.base2.Student");
        Student student = c.newInstance();
        Field f = c.getField("idCard");
        f.set(student, 10001);
        System.out.println(f.get(student));
        Class clazz = c.getSuperclass();//父类创建对象
        School school = (School) clazz.newInstance();
        Field field = clazz.getDeclaredField("schoolName");
        field.setAccessible(true);
        field.set(school, "华东交大");
        System.out.println(field.get(school));

    }

    @Test
    public void test05() throws Exception {
        Class c = Math.class;
        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        Math math = (Math) constructor.newInstance();
        System.out.println(math);
    }
    @Test
    public void test06() throws Exception{
        Class<Student> c = (Class<Student>) Class.forName("cn.jp.base2.Student");
        Student student=c.newInstance();
        System.out.println(student);
    }
    @Test
    public void test07() throws Exception{
        Class<Student> c = (Class<Student>) Class.forName("cn.jp.base2.Student");
        Constructor constructor=c.getConstructor();
        Student student= (Student) constructor.newInstance();
        System.out.println(student);
        Constructor constructor1=c.getDeclaredConstructor(Integer.class,String.class);
        constructor1.setAccessible(true);
        Student student1=(Student) constructor1.newInstance(1001,"许馆");
        Constructor constructor2=c.getConstructor(Integer.class,String.class,String.class);
        Student student2= (Student) constructor2.newInstance(1002,"xiahu","鼎湖山");
        System.out.println(student2);
    }
}
