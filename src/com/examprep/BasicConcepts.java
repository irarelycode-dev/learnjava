package com.examprep;

public class BasicConcepts {
    public static void main(String[] args) {
        double a=10/0.0;
        double c=0/0.0;
        double b=0/4.0;
        double d=0.0/0;
//        int e=4/0;
        System.out.println(a);
        System.out.println(c);
        System.out.println(b);
        System.out.println(d);
//        System.out.println(e);
        System.out.println(2.0%0);

        //data type range questions

        Integer i=new Integer(257);
        byte x=i.byteValue();
        System.out.println(x); //1 i value exceeds the byte range by 1. So 1 is returned.

    }
}
