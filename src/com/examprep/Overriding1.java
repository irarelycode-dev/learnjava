package com.examprep;

class BaseOne{
    public void methodOne(){
        System.out.println("A");
        methodTwo();
    }
    public void methodTwo(){
        System.out.println("B");
    }
}

class Derived extends BaseOne{
    public void methodOne(){
        super.methodOne();
        System.out.println("C");
    }
    public void methodTwo(){
        super.methodTwo();
        System.out.println("D");
    }
}

public class Overriding1 {
    public static void main(String[] args) {
        BaseOne b=new Derived();
        BaseOne b1=new BaseOne();
        //Derived d=(Derived)b1;//this will give a runtime error.
        b.methodOne();
        System.out.println("****");
    }
}


//downcasting will give a runtime error in java if at runtime it couldn't refer to similar types.
// For eg: Object a="macs concordia";
//String b=(String)a; This is possible since a could reference a string at runtime.

//but Object a=10;
//String b=(String)a; This is not possible since a has a reference to an integer.