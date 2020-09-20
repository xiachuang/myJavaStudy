package cn.hdj.test;

 class Thread1 {
    private static Boolean bl;
    public static void main(String[] args) {

        Object lock=new Object();
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                int n=15;
                while(n>0){
                    synchronized (lock){
                        try {
                            Thread.sleep(500);
                            System.out.println(Thread.currentThread().getName()+":"+"运行了");
                            lock.wait();
                            lock.notifyAll();
                            bl=true;
                            n--;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if(bl==true){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            bl=false;
                            System.out.println(Thread.currentThread().getName() + " " + "---");
                            lock.notify();


                        }

                    }
                }
            }
        });
        System.out.println("开始！！");
        threadA.setName("A:");
        threadA.start();
        threadB.setName("B:");
        threadB.start();
    }
}
