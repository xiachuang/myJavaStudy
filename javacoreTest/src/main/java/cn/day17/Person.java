package cn.day17;

public class Person {
    private Integer id;
    private String name;
    private EnumTest sex;

    public Person() {
        super();
    }
    public Person(Integer id,String name,EnumTest sex){
        this.id=id;
        this.name=name;
        this.sex=sex;
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

    public EnumTest getSex() {
        return sex;
    }

    public void setSex(EnumTest sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
