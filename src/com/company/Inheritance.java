package com.company;
import static java.lang.System.out;

class Base{
    int x;
    public Base(){
        out.println("I'm a constructor Base");
    }
    public Base(int a){
        out.println("I'm a base class constructor overloaded:"+a);
    }
    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return this.x;
    }
}

class Derived extends Base{
    int y;
    public Derived(){
        super(10);
        out.println("I'm a constructor of Derived");
    }

    public Derived(String name){
        super();
        out.println("I'm a constructor in derived class,I'm overloaded"+name);
    }
    public void setY(int y){
        this.y=y;
    }
    public int getY(){
        return this.y;
    }
}

class ChildOfDerived extends Derived{
    public ChildOfDerived(){
        super(new String("vignesh"));
    }
}

public class Inheritance {
    public static void main(String[] args) {
        ChildOfDerived derivedChild=new ChildOfDerived();
    }
}
