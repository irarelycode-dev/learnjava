package com.datastructures.greedy;

public class Substring {
    static String subStringPattern(int a,int b){
        int len=a+b;
        String ans=new String("");
        char A='a',B='b';
        while(len>0){
            System.out.println("len and string:"+len+" "+ans+" "+ans.length());
            if((ans+A).lastIndexOf("aaa")==-1 && a>0){
                ans=ans+A;
                a--;
            }else if((ans+B).lastIndexOf("bbb")==-1 && b>0){
                ans=ans+B;
                b--;
            }
            len--;
        }
        return ans;
    }
    public static void main(String[] args) {
        String ans=subStringPattern(10,12);
        System.out.println(ans);
        System.out.println(ans.length());
    }
}
