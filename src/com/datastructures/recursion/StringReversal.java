package com.datastructures.recursion;

public class StringReversal {
    public static String reverseString(String s){
        if(s.length()==0) return "";
        return reverseString(s.substring(1))+s.charAt(0);
    }
    public static int reverseNumber(int num,int digits){
        if(num==0) return 0;
        return (int) ((num%10)*Math.pow(10,digits-1)+reverseNumber(num/10,--digits));
    }
    public static void main(String[] args) {
        String name="vignesh";
        int num=12345;
        System.out.println(reverseString(name));
        System.out.println(reverseNumber(num,5));
    }
}
