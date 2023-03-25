package concurrency.udemy;

public class Priority {
    private static class CustomThread implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread name:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new CustomThread());
        Thread t2=new Thread(new CustomThread());
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.setName("t1 thread");
        t2.setName("t2 thread");
        t1.start();
        t2.start();
    }
}
