package cn.hdj.day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01 {

    public void test01(){
        List<Object> list=new ArrayList<>();
        list.add(1);
        list.add(true);
        list.add("success");
        list.add(3.1426);
        System.out.println(list.get(2));
        System.out.println(list.toString());
        list.add(2,"飞翔");
        System.out.println(list.get(2));
        list.remove(2);
        Integer a=1;
        list.remove(a);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.indexOf(true));
        System.out.println(list.isEmpty());
        Iterator<Object> iterable=list.iterator();
        for (Object o:list){
            System.out.println(o);
        }
    }
}
