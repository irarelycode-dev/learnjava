package com.datastructures.recursion;

import java.util.ArrayList;

public class PhoneDigitCombinations {
    public void findCombinations(String[] s,StringBuilder ans,ArrayList<String> res){
        if(ans.length()==s.length){
            res.add(ans.toString());
            return;
        }
        String tmp=s[ans.length()-1];
        for(int i=0;i<tmp.length();i++){
            char ch=tmp.charAt(i);
            findCombinations(s,ans.append(ch),res);
            ans.deleteCharAt(ans.length()-1);
        }
    }
    public static void main(String[] args) {

    }
}
