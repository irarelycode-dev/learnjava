package com.datastructures.recursion;

import java.util.*;

public class StringCombinations {
    public static void findPermutations(String s,String answer){
        if(s.length()==0){
            System.out.println(answer);
            return;
        }
        for(int i=0;i<s.length();i++){
            char currChar=s.charAt(i);
            String tmpStr=s.substring(0,i)+s.substring(i+1);
            findPermutations(tmpStr,answer+currChar);
        }
    }

    public static void findPermutationSum(int[] nums,int target,ArrayList<Integer> al){
        int sum=al.stream().mapToInt(a->a).sum();
        if(sum==target) {
            System.out.println(al.toString());
            return;
        }
        if(sum>target) return;
        for(int i=0;i<nums.length;i++){
            int tmp=nums[i];
            int[] tmpArray1=Arrays.copyOfRange(nums,0,i);
            int[] tmpArray2=Arrays.copyOfRange(nums,i+1,nums.length);
            int[] both=Arrays.copyOf(tmpArray1,tmpArray1.length+tmpArray2.length);
            System.arraycopy(tmpArray2,0,both,tmpArray1.length,tmpArray2.length);
            al.add(tmp);
            findPermutationSum(both,target,al);
            al.remove(al.size()-1);
        }
    }
    public static void main(String[] args) {
        String str="abc";
        int[] nums={1,2,3,4,5,6,7};
//        findPermutations(str,new String(""));
        findPermutationSum(nums,14,new ArrayList<>());
    }
}
