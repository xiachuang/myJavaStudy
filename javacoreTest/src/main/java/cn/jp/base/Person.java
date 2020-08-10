package cn.jp.base;

public class Person {
    private int id;
    private String name;
    public int age;

    public Person() {
        super();
    }
    public Person(int id,String name){
        super();
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public  void show(String name){
        System.out.println("name:"+name);

    }
    private void show1(int id){
        System.out.println(id);
    }
}
