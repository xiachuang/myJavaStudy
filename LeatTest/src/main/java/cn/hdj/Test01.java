package cn.hdj;

public class Test01  {
//    static final int i=23;
    private   class p{}
    static{
        int x=5;
    }
    static int x,y;
    private  static final String MESS="adad";
    public static void main(String[] args) {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);

    }
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    void show(){
        show1();
    }
   static void show1(){
        String hello$sd1;
        Test01 c=new Test01();
        c.show();
        
    }
}
