package cn.hdjd.object;

import cn.hdjd.domain.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DemoObject01 {
    public static void main(String[] args) throws IOException {
        show();
    }
    private  static  void show() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/file/utf.txt"));
        Person p=new Person();
        p.setName("肖鱼");
        p.setAge(22);
        oos.writeObject(p);
        oos.close();
    }
}
