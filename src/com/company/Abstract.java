package com.company;
import static java.lang.System.out;

//abstract classes cannot be instantiated.
//only concrete classes can be instantiated.
abstract class BaseTwo{
    public BaseTwo(){
        out.println("Basetwo constructor");
    }
    abstract public void greet();
    abstract public void greet2();
}

class ChildTwo extends BaseTwo{
    @Override
    public void greet(){
        out.println("ChildTwo Good Morning");
    }
    @Override
    public void greet2(){
        out.println("ChildTwo greet2 good morning");
    }
}

abstract class ChildThree extends BaseTwo{
    public void th(){
        out.println("I am good");
    }
}

public class Abstract {
    public static void main(String[] args) {

    }
}
