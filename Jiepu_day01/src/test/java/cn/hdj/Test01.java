package cn.hdj;

import org.testng.annotations.Test;

public class Test01 {
    @Test
    public void  test01(){
        int[] arr= {2,321,21,2,3,4,32,53,53,33,245};
        int len=arr.length;
        int temp=0;
        for(int i=len-1;i>0;i--) {
            for(int j=0;j<i;j++) {
                if(arr[j]>arr[j+1]) {
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
    }
    @Test
    public void test02(){
        int[]  arr={12,23,232,321,1,213,1,8,97,6,};
        int len=arr.length;
        int temp=0;
        for(int i=1;i<len;i++){
            temp=arr[i];
            int j=i;
            while(j>0&&temp<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
        long time=System.currentTimeMillis();
    }
}

