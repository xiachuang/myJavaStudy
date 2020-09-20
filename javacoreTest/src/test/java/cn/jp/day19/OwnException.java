package cn.jp.day19;

public class OwnException extends Exception {
    public OwnException() {
        System.out.println("发生异常");
    }
    public OwnException(String msg){
        super(msg);
    }
}
