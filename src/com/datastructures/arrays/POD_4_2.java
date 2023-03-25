package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class POD_4_2 {
    public static Object[] queueToken(int[] nums){
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> withoutToken=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-1){
                al.add(nums[i]);
            }else{
                withoutToken.add(nums[i]);
            }
        }
        res.addAll(al);
        res.addAll(withoutToken);
        return res.toArray();
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        scan.nextLine();
        String[] str=scan.nextLine().split(",");
        int[] nums=new int[str.length];
        for(int i=0;i<str.length;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        Object[] res=POD_4_2.queueToken(nums);
        for(int i=0;i<N;i++){
            if(i!=N-1) System.out.print(res[i]+",");
            else System.out.println(res[i]);
        }
    }
}
