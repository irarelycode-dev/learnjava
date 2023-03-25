package concurrency.udemy;

class Worker implements Runnable{
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon thread is running");
        }
    }
}

class NormalWorker implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Normal worker thread running...");
    }
}

public class DaemonAndWorker {
    public static void main(String[] args) {
        String name= Thread.currentThread().getName();
        System.out.println(name);
        Thread t1=new Thread(new Worker());
        Thread t2=new Thread(new NormalWorker());
        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println(t1.isDaemon());
        System.out.println(t1.isAlive());
    }
}
