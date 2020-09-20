package cn.day19;

public class DivisionByZero {
    public static void main(String[] args) throws Exception {
            division();
    //            division2();
    }
    public static void division(){
        try{
            double b=10/0;
            System.out.println("---------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("异常已处理完成");
        }
    }
    public static  void division2() throws Exception {
        double b=10/0;
        throw new Exception("错误！！");
    }

}
