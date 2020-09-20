package cn.briup;

import java.io.Serializable;

public class Person implements Serializable {
    private  Integer id;
    private  String personName;
    private  Integer age;
    public Person(){

    }
    public  Person(Integer id,String personName,Integer age){
        this.id=id;
        this.personName=personName;
        this.age=age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
