package com.datastructures.divideandconquer;

public class Multiplication {
    static int multiply(String x,String y){
        if(x.length()==1){
            return Integer.parseInt(x)*Integer.parseInt(y);
        }
        int xLength=x.length();
        int yLength=y.length();
        String x1=x.substring(0,x.length()/2);
        String x2=x.substring(x.length()/2);
        String y1=y.substring(0,y.length()/2);
        String y2=y.substring(y.length()/2);
        int r1=multiply(x1,y1);
        int r2=multiply(x1,y2);
        int r3=multiply(x2,y1);
        int r4=multiply(x2,y2);
        return (int) (Math.pow(10,x.length())*r1+Math.pow(10,x.length()/2)*(r2+r3)+r4);
    }

    public static void main(String[] args) {
        System.out.println(multiply("4512354","1238970"));
    }
}
