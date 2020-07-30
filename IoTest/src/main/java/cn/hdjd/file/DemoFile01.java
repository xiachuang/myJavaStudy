package cn.hdjd.file;

import java.io.File;

public class DemoFile01 {
    public static void main(String[] args) {
  //  show01();
 //   show();
        show2();
    }
    private  static  void show2(){
        File f1=new File("src/file/a/1.jpg");
        long length = f1.length();
        System.out.println(length);
        File f2=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\a\\3.jpj");
        System.out.println(f2.length());//文件夹没有大小概念
    }
    private  static  void show(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\分页Page.txt");
        File f2=new File("/分页Page.txt");
        String path = f.getPath();
        String path1 = f2.getPath();
        System.out.println(path);
        System.out.println(path1);
        String name = f.getName();
        System.out.println(name);
    }
    private static  void show01(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\分页Page.txt");
        String path = f.getAbsolutePath();
        System.out.println(path);
    }
}
