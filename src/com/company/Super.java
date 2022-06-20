package com.company;
import static java.lang.System.out;

class BaseClass{
    public BaseClass(){
        out.println("base class constructor");
    }
    public void parentMethod(){
        out.println("parent method");
    }
}

class Child extends BaseClass{
    public Child(){
        super();
    }
    public void callParentMethod(){
        super.parentMethod();
    }
}

public class Super {
    public static void main(String[] args) {
        Child child=new Child();
        child.callParentMethod();
    }
}
