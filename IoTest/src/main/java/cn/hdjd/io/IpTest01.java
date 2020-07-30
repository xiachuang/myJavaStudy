package cn.hdjd.io;

import java.io.FileInputStream;
import java.io.IOException;

//输入流  从文件中  读取数据  到内存中
//输出流
public class IpTest01 {
    public static void main(String[] args) throws IOException {
    /*
        StringBuffer c=new StringBuffer();
        c.append("hello");
        System.out.println(c);
*/
 //   show();
  //      show1();
        show2();
    }
    private  static  void  show() throws IOException {
        FileInputStream fis=new FileInputStream("src/file/a.txt");
        int len=0;
        byte[] bytes=null;
        while ((len=fis.read())!=-1){
            Byte[] bytes1=new Byte[len];
            System.out.println(len);

        }
        fis.close();
    }
    /*
    一次读取多个字符
     */
    private  static  void show1() throws IOException {
        FileInputStream fis=new FileInputStream("src/file/a.txt");
        byte[] bytes=new byte[10];
        int len=fis.read(bytes);
        System.out.println(new String(bytes));
    }
    private  static  void show2()throws IOException {
        FileInputStream fis=new FileInputStream("src/file/a.txt");
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }
}
