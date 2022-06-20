package com.company;

public class methods {
    static int logic(int x,int y){
        int z;
        if(x>y){
            z=x+y;
        }else{
            z=(x+y)*5;
        }
        return z;
    }
    public static void main(String[] args){
        int a=20;
        int b=10;
        //method invocation
        /*
        * methods object=new methods();
        * int c=object.logic(a,b);
        * */
        int c=logic(a,b);
        int a1=21;
        int b1=23;
        int d=logic(a1,b1);
        System.out.println(d+" "+a1+" "+b1);
    }
}
