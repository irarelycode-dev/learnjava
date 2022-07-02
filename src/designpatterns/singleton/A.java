package designpatterns.singleton;

public class A {
    private static A object=new A();
    private static A getInstance(){
        return object;
    }
    private A(){}
    public void doSomething(){}
}


