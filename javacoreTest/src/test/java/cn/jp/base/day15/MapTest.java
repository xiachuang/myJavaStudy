package cn.jp.base.day15;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
    Map<String,Object> map=new HashMap<>();
    @Test
    public void test01(){
        map.put("1",1);
        map.put("name","xiachuang");
        map.put("bool",true);
        Boolean bl=(Boolean) map.get("bool");
        if(bl){
            System.out.println("yes....");
        }
        Set<String> set=map.keySet();
        for(String s:set){
            System.out.println( map.get(s));
        }
        Set set1=map.entrySet();
        for(Object obj:set1){//key  和 values 都取出来
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry);
        }
    }
    @Test
    public void test02(){
        Map<Integer,Object> map=new TreeMap<>();

    }
}
