package cn.jp.base.day5;
import  org.junit.Test;
public class forTest {
    @Test
    public void test01(){
        int sum=1;
        for(int i=1;i<11;i++){
            sum=sum*i;
        }
        int n=1;
        while(n<11){
            sum=sum*n;
            n++;
        }
       do {
           sum=sum*n;
           n++;
       }while (n<11);
    }

    @Test
    public void test02(){
        int x=10;
        int sum=1;
        for(int i=x;i>0;i--) {
            sum = sum * i;

            if (i == 1) {
                System.out.print(i + "=" + sum);
            } else {
                System.out.print(i + "*");
            }
        }
    }
    @Test
    public void Test03(){

        for (int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+"    ");
            }
            System.out.println();
        }
    }


}
