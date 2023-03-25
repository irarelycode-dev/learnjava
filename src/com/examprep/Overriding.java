package com.examprep;


class Father{
    public void car(){
        System.out.println("Father's car");
    }
    public void bike(){
        System.out.println("Father's Bike");
    }
}

class Son extends Father{
    public void car(){
        System.out.println("Son's car");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Son obj=new Son();
        Father obj1=new Son();
        Father obj2=(Father) new Son();
        Father obj3=new Father();
//        Son obj4= (Son) obj3;
        obj.car(); //Son's car
        obj1.car();//Son's car
        obj2.car();//Son's car
        obj.bike();//Father's bike
        obj3.car();//Father's car
//        obj4.car();//Father's car
    }
}
