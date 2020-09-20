package cn.hdj.day13;

import java.util.*;

public class Test03 {
    public static   List<Student> student=new ArrayList<>();
    public static  int num=1001;

    public static void main(String[] args) {
        test02();
    }
    public  static void test02() {
        System.out.println("*****************学生管理系统*********************");
        System.out.println("*            1.添加学生                         **");
        System.out.println("*            2.查询所有学生                     **");
        System.out.println("*            3.根据学号删除学生                  **");
        System.out.println("*            4.批量添加学生                      **");
        System.out.println("*            5.批量删除学生                      **");
        System.out.println("*            6.搜索学生                         **");
           //sds: while  后面加 break :sds 结束
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String n1 = scanner.nextLine();
            int n=Integer.parseInt(n1);
            switch (n) {
                case 1:
                    System.out.println("请输入学生姓名:");
                    String name = scanner.nextLine();
                    add(name);
                    break;
                case 2:
                    selectStudent();
                    break;
                case 3:
                    System.out.println("请输入学生学号：");
                    String id1 = scanner.nextLine();
                    int id=Integer.parseInt(id1);
                    delete(id);
                    break;
                case 4:
                    batchAdd();
                    break;
                case 5:
                    batchDelete();
                    break;
                case 6:
                    search();
                    break;
                case 7:
                    System.out.println("退出程序");
                    return;
//                    break sds;
            }
        }
    }
    public  static void search(){
        Scanner scanner=new Scanner(System.in);
        String name;
        int index=0;
        System.out.println("输入学生名：");
        name=scanner.nextLine();
        for(int i=0;i<student.size();i++){
            if(student.get(i).getName().equals(name)){
                index=i;
                break;
            }
        }
        System.out.println(student.get(index));
        System.out.println("请继续操作");
    }
    public static  void batchDelete(){
        Scanner scanner=new Scanner(System.in);
        Map<String,Object> map=new HashMap<>();
        String index="xx";
        System.out.println("请输入需要批量删除的学生Id");

        while (!"#".equals(index)){
            index=scanner.nextLine();
            if(index.equals("#")){
                System.out.println("删除操作完成完成");
            }else{
                Integer id=Integer.parseInt(index);

                if(checkId(id)){
                   delete(id);
//                    System.out.println("删除成功！！");
                }else {
                    map.put("msg",id+"不存在！！");
                    map.put("check","#");
                    System.out.println("删除出现错误输入#退出！！");
                }
            }
        }
    }
    public static Boolean checkId(Integer id){
        Boolean bl=false;
        for(int i=0;i<student.size();i++){
            int c=student.get(i).getId();
            if(id==c){
                bl=true;
                break;
            }
        }
//        System.out.println(bl);
       return bl;
    }
    public static void  batchAdd(){

        Scanner scanner=new Scanner(System.in);
        String name="xx";
        System.out.println("请输入批量的学生名：");
        while(!"#".equals(name)){
            name = scanner.nextLine();
            if(name.equals("#")){
                System.out.println("保存完成");
            }else {
                Student student1=new Student();
                student1.setId(num);
                student1.setName(name);
                student1.setAge((int)(Math.random()*50));
                student.add(student1);
//            System.out.println("success"+num);
                num++;
            }
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
            int index=0;
            int len=student.size();
            for(int i=0;i<len;i++){
                if(student.get(i).getId()==id){
                    index=i;
                    break;
                }
            }

            student.remove(index);
    }
}
