package concurrency.udemy;

public class CustomObjectLocks {
    private static int counter1=0;
    private static int counter2=0;

    private static final Object lock1=new Object();
    private static final Object lock2=new Object();

    private static void increment1(){
        synchronized (lock1){
            counter1++;
        }
    }

    private static void increment2(){
        synchronized(lock2){
            counter2++;
        }
    }

    public static void process(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++) increment1();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++) increment2();
            }
        });
        t1.start();
        t2.start();
        System.out.println("Counter 1:"+counter1);
        System.out.println("Counter 2:"+counter2);
    }

    public static void main(String[] args) {
        process();
    }

}
