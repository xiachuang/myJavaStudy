package cn.jp.base;
import org.junit.Test;
public class TestStr {
    @Test
    public void Test01(){
        String str="sdasdsada";
        String str1="dsadasd";
        String str2=str+str1;
        System.out.println(str2);
        StringBuffer strb=new StringBuffer();
        strb.append("sadasdasdas");
        System.out.println(strb);
    }
}
