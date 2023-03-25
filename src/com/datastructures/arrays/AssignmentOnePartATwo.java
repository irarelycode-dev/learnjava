package com.datastructures.arrays;

import java.util.*;

public class AssignmentOnePartATwo {
    public String replaceCharacters(String str){
        int length=str.length();
        String consonants="",repeatingConsonants="",numericals="",vowels="",vowelsOne="aeiou",vowelsTwo="AEIOU";
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<length;i++){
            char chr=str.charAt(i);
            if(hm.containsKey(chr)){
                hm.put(chr,hm.get(chr)+1);
            }else{
                hm.put(chr,1);
            }
        }
        for(int i=0;i<length;i++){
            char chr=str.charAt(i);
            if(vowelsOne.contains(chr+"") || vowelsTwo.contains(chr+"")){
                vowels+=chr;
            }else if(Character.isDigit(chr)){
                numericals+=chr;
            }else{
                int occurence=hm.get(chr);
                if(occurence>1) {
                    repeatingConsonants+=chr;
                    hm.put(chr,-1);
                }
                else if(occurence==1) consonants+=chr;
            }
        }
        return consonants+repeatingConsonants+" "+numericals+" "+vowels;
    }
    public static void main(String[] args) {
        AssignmentOnePartATwo obj=new AssignmentOnePartATwo();
        System.out.println(obj.replaceCharacters("assignment1"));
    }
}

//time complexity: O(n)
//space complexity: O(n)