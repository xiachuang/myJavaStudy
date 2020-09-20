package cn.day19;

public class MyException extends RuntimeException {
    public MyException(){
        super("发生错误");
    }
    public MyException(String msg){
        super(msg);
    }
}
