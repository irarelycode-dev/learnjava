package com.datastructures.arrays;

import java.util.*;

public class MinimumSlidingWindow {
    public static String findMinimumSubstring(String s,String t){
        int len=s.length()+1;
        String substring="";
        Map<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!hash.containsKey(t.charAt(i))){
                hash.put(t.charAt(i),1);
            }else{
                hash.put(t.charAt(i),hash.get(t.charAt(i))+1);
            }
        }
        int i=0;
        int j=0;
        int count=hash.size();

        while(j<s.length()){
            if(hash.containsKey(s.charAt(j))){
                hash.put(s.charAt(j),hash.get(s.charAt(j))-1);
                if(hash.get(s.charAt(j))==0){
                    count--;
                }
            }
            while(count==0){
                if(j-i+1<len){
                    len=j-i+1;
                    substring=s.substring(i,j+1);
                }
                if(hash.containsKey(s.charAt(i))){
                    hash.put(s.charAt(i),hash.get(s.charAt(i))+1);
                    if(hash.get(s.charAt(i))==1){
                        count+=1;
                    }
                }
                i++;
            }
            j++;
        }
        return substring;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String t=scan.nextLine();
        System.out.println(findMinimumSubstring(s,t));
    }
}
