package cn.hdjd.write;

import java.io.FileWriter;

public class DemoTry01 {
    public static void main(String[] args) {
        try(
                FileWriter fw=new FileWriter("src/file/a.txt");
                ){
            fw.write("你好呀");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
