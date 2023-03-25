package com.examprep;

class Deriveds1 extends Deriveds{
    public void f(){
        System.out.println("public f() in Deriveds1");
    }
}

class Deriveds extends PolymorphicReference{
    public void f(){
        System.out.println("public f()");
    }
}

public abstract class PolymorphicReference {
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PolymorphicReference o=new Deriveds1();
        o.f();
    }
}

// methods declared private are not inherited.
// So there is no polymorphism.
// So when there is no polymorphism, then search will beign in the parent class.
