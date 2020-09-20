package cn.day17;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public  static List<Student> list=new ArrayList<>();
    public static void main(String[] args) {
        Student student=new Student(1001,"夏创",79);
        add(student);
        /*
            循环添加
         */
    }
    public  static  void add(Student student){
        for(int i=0;i<list.size()-1;i++){
          if(student.getId()==list.get(i).getId()&&student.getName()==list.get(i).getName()&&student.getGrade()==list.get(i).getGrade()){
              list.add(student);
              break;
          }
        }
    }

}
