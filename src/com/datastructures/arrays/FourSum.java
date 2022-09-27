package com.datastructures.arrays;

import java.util.*;

public class FourSum {
    public List<List<Integer>> getQuads(int[] nums,int target){
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=nums.length-1;j>i;j--){
                int ptr1=i+1,ptr2=j-1;
                long boundarySum=nums[i]+nums[j];
                while(ptr1<ptr2){
                    long sum=boundarySum;
                    sum+=nums[ptr1]+nums[ptr2];
                    if(sum>target) ptr2--;
                    if(sum<target) ptr1++;
                    if(sum==target){
                        List<Integer> quad=new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[ptr1]);
                        quad.add(nums[ptr2]);
                        set.add(quad);
                        ptr1++;
                        ptr2--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        FourSum obj=new FourSum();
        List<List<Integer>> result=obj.getQuads(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
        Iterator<List<Integer>> itr= result.iterator();
        while(itr.hasNext()){
            for(Integer i:itr.next()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
