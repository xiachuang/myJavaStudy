package cn.test.Test01;
import org.junit.Test;
public class TestObject {
    @Test
    public  void test01() throws IllegalAccessException, InstantiationException {
        Class<UserInfo> clazz=UserInfo.class;
        clazz.newInstance();//��ȡ�¶���
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        new Thread(()->{//lamda���ʽ

        }).start();
    }
}
