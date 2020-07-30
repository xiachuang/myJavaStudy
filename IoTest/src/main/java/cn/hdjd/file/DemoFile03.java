package cn.hdjd.file;

import cn.hdjd.test.Hello;

import java.io.File;

public class DemoFile03 {
    public static void  main(String[] args) {
        Hello h=new Hello();
        //show01();
        show2();
    }
    /*
    遍历文件夹  隐藏的也可以遍历到
     */
    private static  void show01(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file");
       String[] arr= f.list();
        for ( String c:arr
             ) {
            System.out.println(c);
        }
    }
    private static  void show2(){
        File f=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file");
        f.delete();

        f.listFiles();
        for (File file : f.listFiles()) {
            System.out.println(file);
        }
        File file=new File("sd");
        String file1=file.getAbsolutePath();

    }
}
