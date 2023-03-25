package concurrency.udemy;

class Process{
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Inside produce method...");
            wait();
            System.out.println("After wait in produce method");
        }
    }
    public void consumre() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println("Consume method is executed...");
            notify();
            System.out.println("Will this run?");
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        Process p=new Process();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumre();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
