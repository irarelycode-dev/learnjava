package com.company;
import static java.lang.System.out;

class Phone{
    public void name(){
        out.println("My name is java");
    }
    public void greet(){
        out.println("greeting you");
    }
}

class Smartphone extends Phone{
    public void playMusic(){
        out.println("playing music on smartphone");
    }
    public void swagat(){
        out.println("Aapka swagat hai");
    }
    @Override
    public void name(){
        out.println("My name is java in class two");
    }
}

public class MethodDIspatch {
    public static void main(String[] args) {
        //superclass type can be assigned to subclass reference
        Phone phone=new Smartphone();
        //this is not allowed
        //Smartphone smartphone=new Phone();
        phone.greet();
        phone.name();
        //phone.playMusic(); this is not allowed
    }
}

//dynamic dispatch is used in runtime polymorphism
//reference object is created at run time.