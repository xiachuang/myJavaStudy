package cn.briup.xia.exception;

public class MyException extends RuntimeException {
    public MyException() {
        super("查询或保存错误");
    }

}
