package designpatterns.singleton;

public class B {
    private static B object;
    private B(){}
    public static B getB(){
//        if(object==null){
//            synchronized(Singleton.class){
//                if(object==null){
//                    object=new Singleton();
//                }
//            }
//        }
        return object;
    }
    public void doSomething(){}
}
