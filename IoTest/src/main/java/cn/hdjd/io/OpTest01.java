package cn.hdjd.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OpTest01 {
    public static void main(String[] args) throws IOException {

        show();
        show1();
        show3();
    }
    private static void show() throws IOException {
        File f=new File("src/file/a.txt");
        FileOutputStream fos=new FileOutputStream(f);
        fos.write(123);
        fos.close();
    }
    private  static  void show1() throws IOException{
        FileOutputStream fos=new FileOutputStream("src/file/a.txt",true);//true  append  追加写  false  新文件
        byte[] b="夏创加油".getBytes();
        fos.write(b);
        fos.close();
    }
    //写写换行
    private  static  void show3() throws IOException {
        FileOutputStream fos=new FileOutputStream("src/file/a.txt",true);//t
        for(int i=0;i<10;i++){
            fos.write("hello".getBytes());
            fos.write("\r\n".getBytes());
        }
    }
}
