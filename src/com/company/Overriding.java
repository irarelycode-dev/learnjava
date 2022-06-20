package com.company;
import static java.lang.System.out;

class A{
    public int a;
    public int harry(){
        return this.a;
    }
    public void meth3(){
        out.println("I'm meth3 of class A");
    }
}
class B extends A{
    @Override
    public void meth3(){
        out.println("I'm meth 3 of class B");
        super.meth3();
    }
    public int meth3(int x){
        return x;
    }
}
//when a derived class has a method with same name,same arguments,same return type and access modifiers greater than that of base class, the method in derived class is said to be overrided
public class Overriding {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        b.meth3();
        out.print(b.meth3(10));
    }
}
