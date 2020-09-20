package cn.hdj.day11;

public class Student extends Person{
    private String idCard;
    @Override
    void eat() {

    }

    @Override
    void sleep() {

    }
    public void study(){
        System.out.println("我爱工作");
    }
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public Student(String name,Integer age,String idCard){
        super(name, age);
        this.idCard=idCard;
    }
}
