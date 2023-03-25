package com.examprep;

class PrivateMethodClass{
    private String privateMethodClass(){
        return "vignesh";
    }

    static String staticMethod(){
        return "static method in parent class";
    }
}
public class PrivateMethods extends PrivateMethodClass {

    private String privateMethodClass(){  // this is not overriding. It is shadowing.
        return "never say never";
    }

    static String staticMethod(){
        return "static method in child class";
    }

    public static void main(String[] args) {
        PrivateMethods obj=new PrivateMethods();
        System.out.println(obj.privateMethodClass()); //never say never
        System.out.println(PrivateMethodClass.staticMethod()); //static method in parent class
        System.out.println(PrivateMethods.staticMethod()); //static method in child class
    }
}


// a private or static method cannot be overridden. If you create a method with same name and argument list,
// it will shadow the method or hide the method.