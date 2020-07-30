package cn.hdjd.test;

import org.testng.annotations.Test;

public class File {

    @Test
    public  void test(){
        java.io.File f=new java.io.File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file\\a.txt");
        String name=f.getName();
        f.getAbsolutePath();

    }
}
