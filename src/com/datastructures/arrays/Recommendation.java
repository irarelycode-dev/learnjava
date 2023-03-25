package com.datastructures.arrays;

import java.util.*;

public class Recommendation {

    public int compare(String str1,String str2){
        for(int i=0;i<str1.length();i++){
            if(i<str2.length()){
                if(str1.charAt(i)!=str2.charAt(i)){
                    return i+1;
                }
            }else{
                return i+1;
            }
        }
        return 0;
    }
    public int recommendWords(String[] str){
        int sum=0;
        int maximumSoFar=Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++){
            int count=0;
            for(int j=0;j<str.length;j++){
                boolean startsWith=str[j].startsWith(String.valueOf(str[i].charAt(0)));
                if(startsWith){
                    int diff=0;
                    count++;
                    if(str[i].contains(str[j]) && startsWith && str[i]!=str[j]){
                        diff=str[j].length();
                    }
                    else if(startsWith && str[i]!=str[j]){
                        diff=str[i].length()>str[j].length()?compare(str[i],str[j]):compare(str[j],str[i]);
                    }
                    if(diff>maximumSoFar) maximumSoFar=diff;
                }
            }
            if(count!=0){
                sum+=maximumSoFar;
            }else{
                sum+=1;
            }
            maximumSoFar=Integer.MIN_VALUE;
        }
        return sum>0?sum:1;
    }
    public static void main(String[] args) {
        Recommendation obj=new Recommendation();
        Scanner scan=new Scanner(System.in);
        String[] strs=scan.nextLine().split(" ");
        System.out.println(obj.recommendWords(strs));
    }
}
