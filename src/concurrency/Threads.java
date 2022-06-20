package concurrency;

class MyThread1 extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("my thread is running");
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("thread 2 is good");
            System.out.println("I'm sad");
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        MyThread1 t1=new MyThread1();
        MyThread2 t2=new MyThread2();
        t1.start();
        t2.start();
    }
}
