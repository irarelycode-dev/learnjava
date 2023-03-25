package concurrency.udemy;

public class IntriniscLockObject {
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static synchronized void increment1() {
        counter1++;
    }

    public static synchronized void increment2() {
        counter2++;
    }

    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    if(i%2==0){
                        try {
                            System.out.println("Thread is about to sleep");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    increment1();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++) increment2();
            }
        });
        t1.start();
        System.out.println("counter1:"+counter1);
        t1.join();
        t2.start();
        t2.join();
        System.out.println("counter2:"+counter2);
    }

    public static void main(String[] args) throws InterruptedException {
        process();
    }
}

//there is only one intrinsic lock per Object or class