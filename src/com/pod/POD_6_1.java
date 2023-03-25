package com.pod;

import java.util.ArrayList;
import java.util.Arrays;

public class POD_6_1 {
    static int min=Integer.MAX_VALUE;
    public static void findPermutations(String[] fragments,String target,ArrayList<String> list){
        String str=String.join("",list);
        if(target.equals(str)){
            min=Math.min(min,list.size());
            return;
        }
        if(fragments.length==0) return;
        for(int i=0;i<fragments.length;i++){
            String tmp=fragments[i];
            String[] tmpArray1= Arrays.copyOfRange(fragments,0,i);
            String[] tmpArray2=Arrays.copyOfRange(fragments,i+1,fragments.length);
            String[] tmpArray=Arrays.copyOf(tmpArray1,tmpArray1.length+tmpArray2.length);
            System.arraycopy(tmpArray2,0,tmpArray,tmpArray1.length,tmpArray2.length);
            list.add(tmp);
            findPermutations(tmpArray,target,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        String[] strs={"ba","na","n","a"};
        findPermutations(strs,new String("banana"),new ArrayList<>());
        System.out.println(POD_6_1.min);
    }
}
