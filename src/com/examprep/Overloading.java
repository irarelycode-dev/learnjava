package com.examprep;

import java.util.*;

class ParentTwo{
    void function(){
        System.out.println("some function");
    }
    void function(int a){
        System.out.println("some function with int parameter");
    }
    int function(int a,int b){
        System.out.println("some function with two parameters");
        return b;
    }
//    float function(int b){}//clashes with 2nd function. Parameters are to be different
    String function(String a){
        System.out.println("some function with string argument");
        return a;
    }

//    public void fill(List<String> al){
//        System.out.println("fill method 1");
//    }
//
//    public void fill(List<Integer> al){
//
//    }

    // will have same erasure

    //Java has this thing called "type erasure" which causes problems like this when compiling generic code like this.
    //When compiled, List<Number> and List<Integer> are both just plain List.

}

public class Overloading {
    public static void main(String[] args) {
        String _name="vignesh";
    }
}



//constructor overloading and method overloading comes under run-time polymorphism as overloaded methods or constructors resolve at compile time
//variable names can begin with _ or $
//
