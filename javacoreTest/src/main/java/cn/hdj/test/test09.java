package cn.hdj.test;

public class test09 {
    public static void main(String[] args) {
        short s1=1;
            s1+=1;
        System.out.println(getType(s1));
    }

    private static String getType(Object s1) {
        return s1.getClass().toString();
    }


}
