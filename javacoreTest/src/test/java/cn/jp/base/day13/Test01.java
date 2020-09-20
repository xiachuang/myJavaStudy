package cn.jp.base.day13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test01 {
    @Test
    public void test02(){
        List<Object> list=new ArrayList<>();
        list.add(1);
        list.add(true);
        list.add("success");
        int len=2;
        list.remove(len);
        System.out.println(list.toString());
    }
    @Test
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
    @Test
    public void test03(){
        int[] arr={12,32,42,23,423,422,42};
        int temp=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                        arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
