package cn.jp.base2;

public class Student extends School {
    private Integer age;
    private String address;
    public String  name;
    private static  Integer  idCard;
    public Student(){
        System.out.println("空构造器-------");
    }
    private Student(Integer age,String address){
        System.out.println(address+"------------->"+age);
    }
    public void show(Integer age,String name){
        System.out.println(age+"--------------------->"+name);
    }
    private String show1(String name){
        return name;
    }
    public static void show3(String name){
        System.out.println("静态方法"+name);
    }
    public Student(Integer age,String address,String name){
        this.age=age;
        this.address=address;
        this.name=name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getIdCard() {
        return idCard;
    }

    public static void setIdCard(Integer idCard) {
        Student.idCard = idCard;
    }
    private void showSt(Student student){
        System.out.println(student);
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
