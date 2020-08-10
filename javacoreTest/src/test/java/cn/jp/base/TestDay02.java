package cn.jp.base;
import  org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

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
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=bif.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }
}
