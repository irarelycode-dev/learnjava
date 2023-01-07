package com.recursion;

public class Fibonaci {
    static int fib(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        else return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            System.out.print(fib(i)+" ");
        }
    }
}
