package cn.hdj.accent;

public class Account {
    public int num=0;
    public Account(int num){
        this.num=num;
    }
    public  void show(){
        System.out.println("��Ǯ����ȥ��Ǯ��");
    }
    public  void  add(){
        System.out.println("ûǮ��ȥŬ��תǮ");
    }

    public static void main(String[] args) {
        Account account=new Account(1);
        Thread r1=new Thread(new Body(account));
        Thread r2=new Thread(new Gird(account));
        r1.start();
        r2.start();
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
