package cn.jp.base.day5;
import  org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test06 {
    @Test
    public void test01() {
        int cout = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && j != k && k != i) {
                        System.out.print(i * 100 + j * 10 + k + "  ");
                        cout++;
                    }
                }
            }
        }
        System.out.println(cout);
    }

    @Test
    public void test02() {

        for (int sum = 100; sum <= 200; sum++) {

            for (int i = 2; i < sum; i++) {

                if (sum % i == 0) {
                    break;
                }else {
                    System.out.println(sum+" ");
                    break;
                }
            }
        }
    }
    @Test
    public void test03(){
        for(int num=100;num<1000;num++){
          Boolean bl= check(num);
          if(bl){
              System.out.print(num+" ");
          }

        }
    }
    public boolean check(int num){
        int x=0;
        int y=0;
        int z=0;
        int num1=num;
        x=num%10;
        num=num/10;
        y=num%10;
        num=num/10;
        z=num%10;
        int sum=x*x*x+y*y*y+z*z*z;
        boolean bl=false;
        if(sum==num1){
            bl=true;
        }
        return bl;
    }
    @Test
    public void test04(){
        int num=60;
        for(int k=2;k<=num/2;k++){
            if(num%k==0){
                System.out.print(k+"*");
                num=num/k;
                k=2;
            }
        }
        System.out.println(num);
    }

    @Test
    public void test06(){
        for(int i=2;i<1000;i++) {
            Boolean bl=check1(i);
            if(bl){
                System.out.print(i+"  ");
            }
        }
    }
    public boolean  check1(int num){
        Boolean bl=false;
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<num;i++){
            if(num%i==0){
                list.add(i);
            }
        }
        int count=0;
        for(int c:list){
            count=count+c;
        }
        if(count==num){
            bl=true;
        }
        return bl;
    }
}
