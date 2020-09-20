package cn.jp.base.day13;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
    public static   List<Student> student=new ArrayList<>();
    public static  int num=1001;
    @Test
    public void test02(){
        System.out.println("*****************学生管理系统*********************");
        System.out.println("*            1.添加学生                         **");
        System.out.println("*            2.查询所有学生                     **");
        System.out.println("*            3.根据学号删除学生                  **");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        switch (n){
            case 1:
                System.out.println("请输入学生姓名:");
                String name=scanner.nextLine();
                add(name);
                break;
            case 2:
                selectStudent();
                break;
            case 3:
                System.out.println("请输入学生学号：");
                Integer id=scanner.nextInt();
                delete(id);
                break;
            default:
                System.out.println("退出程序");
                break;
        }
    }
    public static void add(String name){
        if(name.equals("憨批")) {
            Student student1=new Student();
            student1.setId(num);
            student1.setName(name);
            student.add(0, student1);
            num++;
        }else{
            Student student1=new Student();
            student1.setId(num);
            student1.setName(name);
            student.add(student1);
            num++;
        }
    }
    public  static void selectStudent(){
        System.out.println(student.toString());
    }
    public static void delete(Integer id){
            Student student1=null;
            for(Student s:student){
                if(s.getId()==id){
                     student1=s;
                    break;
                }
            }
            student.remove(student1);
    }
}
