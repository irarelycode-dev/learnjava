package com.company;
import static java.lang.System.out;

public class Recursion {
    static int factorial(int x){
        if(x==1 || x==0) return 1;
        return x*factorial(x-1);
    }
    static void multiplication(int x){
        for(int i=0;i<=10;i++){
            out.format("%d x %d=%d",x,i,x*i);
            out.println();
        }
    }
    public static void main(String[] args){
        out.println(factorial(10));
        multiplication(10);
    }
}
