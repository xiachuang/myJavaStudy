package cn.hdj.th;

public class Th01  {
    public static void main(String[] args) {

        Thread tr=new Thread(new Thread01(),"A");
        Thread tr2=new Thread(new Thread01(),"B");
        tr.start();
        tr2.start();
        for (int i=0;i<5;i++){
            System.out.println("A"+i);

        }
    }
}
