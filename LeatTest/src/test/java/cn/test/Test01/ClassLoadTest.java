package cn.test.Test01;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoadTest {
    @Test
    public void testClassload() throws ClassNotFoundException {
        ClassLoader clazz=Class.forName("cn.test.Test01.ClassLoadTest").getClassLoader();
        System.out.println(clazz);
        System.out.println(clazz.getParent());

    }
    @Test
    public  void test01() throws IOException, ClassNotFoundException {
        //·½·¨Ò»
     Properties prpo=new Properties();
//        FileInputStream fos=new FileInputStream("src/jdbc.properties");
        ClassLoader classLoader=Class.forName("cn.test.Test01.ClassLoadTest").getClassLoader();
        InputStream fos=classLoader.getResourceAsStream("jdbc.properties");
        prpo.load(fos);
        String name=prpo.getProperty("user");
        String pwd=prpo.getProperty("password");
        System.out.println("name:   "+name+"    "+pwd);
    }
}
