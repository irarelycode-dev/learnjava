package com.recursion;

public class EvenAndOdd {
    static void printEvenUtil(int start,int end){
        if(start>end) return;
        System.out.print(start+" ");
        printEvenUtil(start+2,end);
    }
    static void printOddUtil(int start,int end){
        if(start>end) return;
        System.out.print(start+" ");
        printOddUtil(start+2,end);
    }
    static void printEvenAndOdd(int n){
        System.out.print("Even:");
        printEvenUtil(0,n);
        System.out.println();
        System.out.print("Odd:");
        printOddUtil(1,n);
    }

    static void printOddEven(int n,int p){
        if(n>p) return;
        if(n%2==0)
            System.out.print(n+" ");

        else System.out.print(n+" ");
        printOddEven(n+1,p);
    }

    public static void main(String[] args) {
        int n=10;
        printEvenAndOdd(n);
        System.out.println();
        printOddEven(0,n);
    }
}
