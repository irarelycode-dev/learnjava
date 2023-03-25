package com.examprep;

class Temp{
    String name=new String("vignesh");
}

public class ShallowCopy {
    public static void main(String[] args) {
        Temp obj1=new Temp();
        Temp obj2=new Temp();
        Temp obj3=obj1;
        System.out.println(obj1.name);
        System.out.println(obj2.name);
        System.out.println(obj3.name);
        obj3.name="isabelle";
        System.out.println(obj1.name);
        System.out.println(obj2.name);
        System.out.println(obj3.name);
    }
}
