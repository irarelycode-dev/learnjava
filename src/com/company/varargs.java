package com.company;
import static java.lang.System.out;

public class varargs {

    public static int sum(int ...args){
        int sum=0;
        for(int a:args){
            sum+=a;
        }
        return sum;
    }

    public static void main(String[] args){
        int result=sum(1,2,3,4,5,6,7,8);
        out.println("result:"+result);
        int result2=sum();
        out.println("result:"+result2);
    }
}
