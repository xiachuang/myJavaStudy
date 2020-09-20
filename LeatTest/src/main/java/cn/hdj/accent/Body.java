package cn.hdj.accent;



public class Body implements Runnable{
    public    Account account;
    public Body(Account account){
        this.account=account;

    }



    @Override
    public void run() {
      synchronized (Object.class){
          while(true) {
          if (account.num % 3 != 0) {
                account.add();
              System.out.println("------------------"+account.num);
              account.num++;
              if(account.num%3==0){
                  Object.class.notify();
                  System.out.println("ืฌย๚มห");
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
}
