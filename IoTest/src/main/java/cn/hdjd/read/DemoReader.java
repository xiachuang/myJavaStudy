package cn.hdjd.read;

import java.io.FileReader;
import java.io.IOException;

public class DemoReader {

    public static void main(String[] args) throws IOException {
     //   show();
        show1();
    }
    private  static  void show() throws IOException {
        FileReader fr=new FileReader("src/file/a.txt");
        int len=0;
        while((len=fr.read())!=-1){
            System.out.println((char)len);
        }
        fr.close();
    }
    private  static  void show1() throws IOException {
        FileReader fr=new FileReader("src/file/a.txt");
        int len=0;
        char[] cha=new char[1024];
        while ((len=fr.read(cha))!=-1){
            System.out.print(new String(cha,0,len));
        }
    }
}
