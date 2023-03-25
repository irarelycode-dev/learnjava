package com.datastructures.arrays;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class AutomationRecommend {

    public int findDifference(String word1,String word2){
        int i=0;
        int len1=word1.length();
        int len2=word2.length();
        boolean flag=false;
        for(i=0;i<len1;i++){
            if(i>=len2) break;
            if(word1.charAt(i)!=word2.charAt(i)){
                flag=true;
                break;
            }
        }
        if(flag==true || (len1>len2 && flag==false)) return ++i;
        return i;
    }
    public int findWordSearchLength(String[] words){
        if(words.length==1) return 1;
        int totalSum=0;
        for(int i=0;i<words.length;i++){
            TreeSet<Integer> ts=new TreeSet<>();
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    ts.add(findDifference(words[i],words[j]));
                }
            }
            totalSum+=ts.last();
            ts.clear();
        }
        return totalSum;
    }
    public static void main(String[] args) {
        AutomationRecommend obj=new AutomationRecommend();
        Scanner scan=new Scanner(System.in);
        String[] str=scan.nextLine().split(",");
        System.out.println(obj.findWordSearchLength(str));
    }
}
