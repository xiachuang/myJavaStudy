package cn.jp.base.day6;

import org.junit.Test;

import java.util.Arrays;

public class Test01 {
    @Test
    public void test01(){
        int[] sum={12,3,1,3,123,34,4,21,2,14,241213,1,2,13,0};
        for(int i=0;i<sum.length;i++){
            int temp=sum[i];
            int t=i-1;
            while(t>=0&&sum[t]>temp){
                sum[t+1]=sum[t];
                t--;
            }
            sum[t+1]=temp;
        }
        for(int c:sum){
            System.out.print(c+"   ");
        }
    }
    @Test
    public void test03(){
        int[] arr = { 6, 1, 8, 2, 9, 3 };
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { // 如果前一个数比后一个小，则交换
                   arr[j]=arr[j]^arr[j+1];
                   arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test02(){
        int[] array1={2,3,5,7,11,13,7,19};
        System.out.println(Arrays.toString(array1));
        int[] array2=new int[array1.length];
        array2=array1;
        for(int i=0;i<array2.length;i++){
            if(i%2==0){
                array2[i]=i;
            }
        }
        System.out.println(Arrays.toString(array1));
        Arrays.copyOfRange(array1,0,3);//拷贝数组  3的前一个
    }
    @Test
    public void test06() {

        int[] arr1={12,23,13,24221,44,421};
        int[] arr=new int[arr1.length];
        arr=arr1;
        System.out.println(Arrays.toString(arr));
    }
}
