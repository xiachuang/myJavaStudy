package cn.hdjd.file;

import java.io.File;

public class DemoFile04  {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\19792\\IdeaProjects\\IoTest\\src\\file");
        get(file);
    }
    public static void get(File file){
        File[] files=file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                get(f);
            }else{
                String name=f.getName();
                Boolean b=name.endsWith(".txt");
                if(b){
                    System.out.println(f);
                }
            }
        }
    }
}
