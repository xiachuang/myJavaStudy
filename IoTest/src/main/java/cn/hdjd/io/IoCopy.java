package cn.hdjd.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoCopy {
    public static void main(String[] args) throws IOException {
        show();
    }
    private  static  void show() throws IOException {
        long s=System.currentTimeMillis();//开始时间
        FileInputStream fis=new FileInputStream("src/file/a.txt");
        FileOutputStream fos=new FileOutputStream("src/file/分页Page.txt",true);
        int len=0;
        byte[] b=new byte[1024];
        while ((len=fis.read(b))!=-1){
            fos.write(b,0,len);
            System.out.println(1);
        }
        fos.close();
        fis.close();
        long e=System.currentTimeMillis();//介绍时得时间
        System.out.println("程序耗时:"+(e-s) +"");
    }
}
