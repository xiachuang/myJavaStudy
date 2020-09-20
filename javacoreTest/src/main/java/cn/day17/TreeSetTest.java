package cn.day17;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Student> set=new TreeSet<>();
        set.add(new Student(1,"许巍",60));
        set.add(new Student(2,"夏创",82));
        set.add(new Student(3,"郝建",82));
        set.add(new Student(4,"圣魔",59));
        for(Object o:set){
            System.out.println(o);
        }
    }
}
