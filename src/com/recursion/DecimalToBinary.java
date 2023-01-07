package com.recursion;

public class DecimalToBinary {
    static String decimalToBinary(int n){
        if(n==0 || n==1) return "1";
        int remainder=n%2;
        return decimalToBinary(n/2)+String.valueOf(remainder);
    }
    public static void main(String[] args) {
        int n=121;
        System.out.println(decimalToBinary(n));
    }
}