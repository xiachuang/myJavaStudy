package cn.jp.base.day4;

import org.junit.Test;

import java.util.*;

public class Test04 {
    @Test
    public void Test02(){
        int temp1=1234;
        int a=(int)(Math.pow(2,31)-1)-(int)(Math.pow(2,8)-1);
        int b=(int)(Math.pow(2,16)-1);
        int x=temp1&a;
        int y=temp1|b;
        System.out.println("消除第八位：" +x+"二进制："+Integer.toBinaryString(x));
        System.out.println("低十六位：" +y+"二进制："+Integer.toBinaryString(y));
        int k=15;
        int l=19;
         k=k^l;
         l=k^l;
         k=k^l;
        System.out.println(k+"------------------>"+l);
    }
    @Test
    public void test01(){
        int temp=Integer.valueOf("100010010",2);
        System.out.println(temp);
    }
    @Test
    public void test02(){
        int[][] arr=new int[10][10];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println();
        }
    }
    @Test
    public  void yuhui(){
      int rows=10;
        for (int i = 0; i < rows; i++) {
            int number = 1;
            // 打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");//格式化输出
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
    @Test
    public void test07(){
        int arr[]={12,1,23,2,4,6,8,10,2,15,1,3,5,7,11,23,100};
        int len=arr.length;
        Set<Integer> list=new HashSet<>();
        List<Integer> ji=new ArrayList<>();
        List<Integer> ou=new ArrayList<>();
        for(int c:arr){
            list.add(c);
        }

        for(Integer c:list){
            if(c%2==0){
                ou.add(c);
            }else{
                ji.add(c);
            }
        }
        int[] arr1=new int[ji.size()];
        int[] arr2=new int[ou.size()];
        for(int i=0;i<ji.size();i++){
            arr1[i]=ji.get(i);
        }
        for(int i=0;i<ou.size();i++){
            arr2[i]=ou.get(i);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] arr3=new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
            arr3[i]=arr1[i];
        }
        int len1=arr1.length;
        int i=0;
        for(int j=arr2.length-1;j>=0;j--){

            arr3[i+len1]=arr2[j];
            i++;
        }
        for(int x:arr3){
            System.out.print(x+"  ");
        }
//        System.out.println(arr3[arr3.length-1]);
    }
}
