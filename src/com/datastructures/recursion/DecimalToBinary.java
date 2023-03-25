package com.datastructures.recursion;

public class DecimalToBinary {
    public static String toBinary(int num){
        if(num==0) return "0";
        if(num==1) return "1";
        return toBinary(num/2)+(num%2);
    }
    public static void main(String[] args) {
        int num=16;
        System.out.println(toBinary(num));
    }
}
