package cn.jp.base;
import  org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class TestDay02 {
    @Test
    public void test(){
        int temp=1;
        int sum=0;
        for(int i=1;i<=10;i++){
           temp=temp*i;
           sum=sum+temp;
        }
        System.out.println(sum);
    }
    @Test
    public void testread() throws Exception {
        FileInputStream fis=new FileInputStream("src/file/a.txt");
        BufferedInputStream bif=new BufferedInputStream(fis);
    }
}
