package cn.test.Test01;

public class UserInfo {
    private Integer id;
    private String name;
    private  Integer age;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public  void show(Integer id,String name,Integer age){
        System.out.println(id+"    "+name+"    "+age);
    }
    public  UserInfo(){

    }
}
