package cn.hdjd.stringbuffer;

import java.io.*;

public class DemoBufferRw {
    public static void main(String[] args) throws IOException {
       // show();
        show1();
    }
    private  static  void show() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/file/c.txt"));
     //   String line=br.readLine();//一次读一行数据
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
    private  static  void show1() throws IOException {
        BufferedWriter fw=new BufferedWriter(new FileWriter("src/file/c.txt",true));
        fw.write("xiachuangnihaoya1");
        fw.close();
    }
}
