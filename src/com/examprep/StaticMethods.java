package com.examprep;

import java.util.*;

class Parent1{
    public static void classMethod(){
        System.out.println("class method in parent");
    }
    public void instanceMethod(){
        System.out.println("Instance method in parent");
    }
    public void hello(){
        System.out.println("Hello method in parent");
        classMethod();
    }
}

class Child1 extends Parent1{
    public static void classMethod(){
        System.out.println("class method in child");
    }
    public void instanceMethod(){
        System.out.println("Instance method in child");
    }
}

public class StaticMethods {
    public static void main(String[] args) {
        Parent1 p1=new Parent1();
        Child1 c1=new Child1();
        c1.instanceMethod();
        c1.classMethod();

        p1.instanceMethod();
        p1.classMethod();

        Parent1 p2=new Child1();
        p2.instanceMethod();
        p2.classMethod(); //class method in parent. No late binding for static methods.

        System.out.println("*****************new concept******************");
        p1.hello();
        c1.hello();

        System.out.println("****************new concept****************");
        Parent1 p3=new Child1();
        p3.hello();

    }
}
