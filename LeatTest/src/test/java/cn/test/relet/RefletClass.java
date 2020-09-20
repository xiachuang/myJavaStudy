package cn.test.relet;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RefletClass {
    @Test
    public  void getMethod() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<Customer> clazz=Customer.class;
        Method method= clazz.getMethod("show", Integer.class, String.class);
        method.invoke(clazz.newInstance(),2,"»ªÎª");
        Map<Object,Object> map=new HashMap<>();
        map.keySet();
    }
}
