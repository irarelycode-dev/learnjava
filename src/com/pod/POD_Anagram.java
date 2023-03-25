package com.pod;

import java.util.Arrays;
import java.util.Scanner;

public class POD_Anagram {
    public boolean areAnagrams(String str1,String str2){
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str1=scan.nextLine();
        String str2=scan.nextLine();
        System.out.println(new POD_Anagram().areAnagrams(str1,str2));
    }
}
