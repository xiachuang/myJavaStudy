package cn.hdjd.object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo01Read {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/file/utf.txt"));
        Object o=ois.readObject();
        ois.close();
        System.out.println(o);
    }
}
