package cn.day17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Person> map=new HashMap<>();
        EnumTest enumTest=EnumTest.MALE;
        EnumTest enumTest1=EnumTest.FEMALE;
        map.put("1",new Person(1001,"夏创",enumTest));
        map.put("2",new Person(1002,"夏曦瑶",enumTest1));
        map.put("3",new Person(1003,"钟健",enumTest));
        map.put("4",new Person(1004,"肖响",enumTest1));
        for(String s:map.keySet()){
            System.out.println(map.get(s));
        }
        System.out.println("--------------------------------->");
       Set entrySet= map.entrySet();
       for (Object o:entrySet){
           Map.Entry entry=(Map.Entry)o;
           System.out.println(entry.getKey()+"  "+entry.getValue());
       }

    }
}
