package cn.day17;

public class Student implements Comparable {
    private  Integer id;
    private String name;
    private  Integer grade;

    public Student(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public Student(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student=(Student)o;
        if(this.grade>student.grade){
            return -1;
        }else if(this.grade<student.grade) {
            return  1;
        }else {
            return  this.getName().compareTo(student.getName())>0?1:-1;
        }
    }

}
