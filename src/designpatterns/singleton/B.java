package designpatterns.singleton;

public class B {
    private static B object;
    private B(){}
    public static B getB(){
        if(object==null){
            synchronized(B.class){
                if(object==null){
                    object=new B();
                }
            }
        }
        return object;
    }
    public void doSomething(){}
}
