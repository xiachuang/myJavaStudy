package cn.test.Test01;
import org.junit.Test;

public class Test02 {
    @Test
    public  void test(){
        int n=10;
            int sum=n++;
        System.out.println(sum);
        int sum1=(n++);
        System.out.println(sum1);
        System.out.println(sum1+(++n));
    }
}
