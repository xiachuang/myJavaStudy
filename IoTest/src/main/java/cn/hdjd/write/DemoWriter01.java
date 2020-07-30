package cn.hdjd.write;

import java.io.FileWriter;
import java.io.IOException;

public class DemoWriter01 {
    public static void main(String[] args) throws IOException {
     //   show();
        show1();

    }
    private  static  void show() throws IOException {
        FileWriter fw=new FileWriter("src/file/c.txt");
        fw.write(98);
        fw.flush();
    }
    //"\r\n" window  换行  /n  Linux   /r mac
    private  static  void show1() throws IOException {
        FileWriter fw=new FileWriter("src/file/c.txt",true);
        char[] cs={'a','b','f','d'};
        fw.write(cs);
        fw.write(cs,0,2);//写一部分
        fw.write("夏创你好，世界你好");
        fw.write("夏创十大",0,2);
        fw.close();
    }
    private  static  void show2(){
        FileWriter fw=null;
        try {
            fw=new FileWriter("src/file/c.txt",true);
            fw.write("年后");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            if (fw != null) {
                try {

                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
