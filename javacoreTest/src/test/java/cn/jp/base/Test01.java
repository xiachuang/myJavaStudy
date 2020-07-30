package cn.jp.base;
import  org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
    @Test
    public void test01(){
        System.out.println("hello  world" );
    }
    @Test
    public void testNN(){
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+"   ");
            }
            System.out.println();
        }
    }
    @Test
    public void find(){

    }
    @Test
    public  void test02(){
        int [] arr={123,213,213,421,1,2,3523,23};
        Arrays.sort(arr);

        for (int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
    @Test
    public void test03(){
    int[] arr={213,32,214,123,412,215,312};
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
    int min=arr[0];
    int max=arr[arr.length-1];
        System.out.println(min+"     "+max);
    //Arrays.stream(arr).max().getAsInt();取最大值
    }
    @Test
    public void test04(){
        int[] arr={213,132,412,123,41,312,342,23423};
        List<Integer> lists= new ArrayList<>();
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            lists.add(arr[i]);
        }
        Object[] arr1=lists.toArray();
    }

}
