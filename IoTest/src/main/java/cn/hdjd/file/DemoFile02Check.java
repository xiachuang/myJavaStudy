package cn.hdjd.file;

import java.io.File;
import java.io.IOException;

public class DemoFile02Check {
    public static void main(String[] args) throws IOException {
    //show01();
   // show02();
        show3();
    }
    private static  void show01() throws IOException {
        File f=new File("src\\file\\a.txt");//绝对相对都可以
         boolean newFile = f.createNewFile();//只能创建文件
        System.out.println(newFile);
    }
    //创建文件夹mkdir  mkdirs
    private  static  void show02(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\b");
        boolean mkdir = f.mkdir();
        System.out.println(mkdir);
        File f1=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\a\\cc\\dd");
         Boolean b= f1.mkdirs();
        System.out.println(b);
    }
    //删除
    private  static  void show3(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\a\\cc\\dd");
        Boolean b1=f.delete();
        System.out.println(b1);
    }
}
