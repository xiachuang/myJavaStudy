package cn.hdj.accent;

public class Gird implements Runnable {
    public   Account account;
    public Gird(Account account){
        this.account=account;
    }

    public Gird() {

    }

    @Override
    public void run() {
        synchronized (Object.class){
            while (true){
                if(account.num%3==0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Object.class.notify();
                    System.out.println(account.num);
                    account.add();
                    account.num++;
                    try {
                        Object.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
