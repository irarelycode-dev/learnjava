package com.examprep;


class ParentOne{
    public String place="chennai";
    public int returnInteger(int num){
        return num;
    }
}

class Child extends ParentOne{
    public String place="dubai";
    public float returnInteger(double num){
        return Float.parseFloat(String.valueOf(num));
    }
}

public class InheritanceQuestions {
    public static void main(String[] args) {
        Child obj=new Child();
        ParentOne obj1=new Child();
        System.out.println(obj.place);
        System.out.println(obj1.place);
        System.out.println(obj.returnInteger(1.4));
        System.out.println(obj1.returnInteger(1));
        System.out.println(obj.returnInteger(12));
    }
}
