package cn.hdjd.object;

import cn.hdjd.domain.Person;

import java.io.*;
import java.util.ArrayList;

public class DemoTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person("夏创",22));
        list.add(new Person("肖响",17));
        list.add(new Person("夏曦瑶",16));
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/file/utf.txt"));
        oos.writeObject(list);
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/file/utf.txt"));
       Object o= ois.readObject();
       ArrayList<Person> list2=(ArrayList<Person>)o;
       for (Person p:list2){
           System.out.println(p);
       }
    }
}
