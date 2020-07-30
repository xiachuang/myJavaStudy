package cn.hdjd.stringbuffer;

import java.io.*;

public class Demo01BufferIo {
    public static void main(String[] args) throws IOException {
    //
        // show();
        show1();
    }
    private  static  void show() throws IOException {
        FileOutputStream fo=new FileOutputStream("src/file/a.txt",true);
        BufferedOutputStream b0=new BufferedOutputStream(fo);
        b0.write("夏创".getBytes());
        b0.close();
    }
    private  static  void show1() throws IOException {
        FileInputStream fs=new FileInputStream("src/file/a.txt");
        BufferedInputStream bi=new BufferedInputStream(fs);
        byte[] by=new byte[1024];
        int len=0;
        while((len=bi.read(by))!=-1){
            System.out.println(len);
            System.out.println(new String(by,0,len));
        }
        bi.close();
    }
}
