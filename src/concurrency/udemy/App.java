package concurrency.udemy;

class Runner1 implements Runnable{

    @Override
    public void run(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Exception in runner 1");
        }
        for(int i=0;i<100;++i){
            System.out.println("Runner 1:"+i);
        }
    }
}

class Runner2 implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<100;++i){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Exception in runner 2");
            }
            System.out.println("Runner 2:"+i);
        }
    }
}

public class App {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runner1());
        Thread t2=new Thread(new Runner2());
        t1.start();
        t2.start();
        System.out.println("Started with the threads");

    }
}
