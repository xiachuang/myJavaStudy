package cn.test.Test01;

import org.junit.Test;

import java.util.Scanner;




public class Test01 {
    //    回文算法
    @Test
    public void test01() {
        int x = 1233212;
        if (x < 10 || x % 10 == 0) {
            System.out.println(false);
        }
        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        boolean bl = temp == x || temp == x / 10;
        System.out.println(x);
        System.out.println(bl);
    }

    @Test
    public void test02() {
        int num = 12332134;
        String str = Integer.toString(num);
        Boolean bl = null;
        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                    bl = true;
                } else {
                    bl = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i <= str.length() / 2; i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                    bl = true;
                } else {
                    bl = false;
                    break;
                }
            }
        }
        System.out.println(bl);
    }

    @Test
    public void test03() {

        int num = -1234567899;
        int reo = 0;

        while (num != 0) {

            int pro = num % 10;
            if (reo> Integer.MAX_VALUE/10 || (reo == Integer.MAX_VALUE / 10 && pro > 7)) break;
            if (reo < Integer.MIN_VALUE/10 || (reo == Integer.MIN_VALUE / 10 && pro < -8)) break;

            reo = reo * 10+pro;
            num = num / 10;
        }
        System.out.println(reo);
        int test=-109%10;//负数的求余 仍是负数、、
        System.out.println(test);
    }
}
