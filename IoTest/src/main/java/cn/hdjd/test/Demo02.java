package cn.hdjd.test;

import java.io.*;
import java.util.HashMap;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        show();

    }
    //将文本排序  复制
    private static  void show() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/file/a.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/file/test.txt"));
        HashMap<String,String> map=new HashMap<>();
        String line;
        while((line=br.readLine())!=null){
            String[] arr=line.split("\\.");
            map.put(arr[0],arr[1]);
        }
        for(String key:map.keySet()){
            String value=map.get(key);
             line=key+"."+value;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
