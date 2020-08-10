package cn.hdjd.properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class DemoProperties01 {
    public static void main(String[] args) throws IOException {
      //  show();
     //   show01();
    show02();
    }
    private  static  void show(){
        Properties prop=new Properties();
        prop.setProperty("夏创","华东交大");
        prop.setProperty("飞鱼","武汉大学");
        prop.setProperty("钱心意","华中科技");
        Set<String> set=prop.stringPropertyNames();
        for (String s : set) {
            System.out.println(s);
        }

    }
    //store 方法  把集合中的方法  放入磁盘中
    //#号 注释
    private  static  void  show01() throws IOException {
        Properties prop=new Properties();
        prop.setProperty("夏创","华东交大");
        prop.setProperty("飞鱼","武汉大学");
        prop.setProperty("钱心意","华中科技");
        FileWriter fw=new FileWriter("src/file/prop.txt");
        prop.store(fw,"data");//字符流  可以写中文  字节流  不可以
        fw.close();
    }
    //load  方法
    private  static  void show02() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("src/file/prop.txt"));//字节流  不能读取  又中文的数据
        for (String s : prop.stringPropertyNames()) {
             String value=prop.getProperty(s);
            System.out.println(s+"=="+value);
        }

    }
}
