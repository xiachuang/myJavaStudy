package cn.hdj.day11;

public class Worker extends Person {
    private  String workId;
    @Override
    void eat() {

    }

    @Override
    void sleep() {

    }
    public  void work(){
        System.out.println("我爱工作");
    }
    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }
    public Worker(String name,Integer age,String workId){
        super(name, age);
        this.workId=workId;
    }
}
