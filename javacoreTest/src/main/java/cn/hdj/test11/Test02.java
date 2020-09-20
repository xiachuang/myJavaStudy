package cn.hdj.test11;

import cn.hdj.day11.Student;
import cn.hdj.day11.Worker;

public class Test02 {
    public static void main(String[] args) {
        Student st=new Student("张三",22,"2324214");
        Worker wk=new Worker("李四",23,"312421");
        System.out.println(st.getName()+"   "+st.getAge()+"   "+st.getIdCard());
        st.study();
        System.out.println(wk.getName()+"   "+wk.getAge()+"   "+wk.getWorkId());
        wk.work();

    }
}
