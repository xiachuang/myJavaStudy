package cn.zhuanhua.Rw;

import java.io.*;

public class DemoRe01 {
    public static void main(String[] args) throws IOException {
        show();
    }
    private  static void show() throws IOException {
        InputStreamReader isp=new InputStreamReader(new FileInputStream("src/file/Ansi.txt"),"UTF-8");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("src/file/utf.txt"),"UTF-8");
        int len=0;
        char[] chars=new char[1024];
        while((len=isp.read(chars))!=-1){
            osw.write(len);
        }
        osw.close();
        isp.close();
    }
}
