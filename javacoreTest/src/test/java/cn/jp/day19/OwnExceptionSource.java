package cn.jp.day19;
import org.junit.Test;
public class OwnExceptionSource {
    @Test
    public void a() throws OwnException {
        int a=11;
       throw new OwnException("错误！！");
    }
}
