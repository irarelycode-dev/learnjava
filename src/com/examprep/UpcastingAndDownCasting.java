package com.examprep;


class Animal{
    public int pincode=600071;
    String getName(){
        return "animal";
    }
}

class Pig extends Animal{
    @Override
    String getName(){
        return "pig";
    }
}

public class UpcastingAndDownCasting {
    public static void main(String[] args) {
        Animal a;
        Pig pp;
        Pig p=new Pig();
        Animal aa=new Animal();
        a=p; //upcasting
//        pp= (Pig) aa; //downcasting
        System.out.println(a.getName());
        System.out.println(a.pincode);
    }
}
