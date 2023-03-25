package com.datastructures.arrays;

import java.sql.Array;
import java.util.*;

public class AssignmentOnePartAThree {
    public ArrayList<ArrayList<Integer>> findPairs(int[] nums){
        int maximumDiff=Integer.MIN_VALUE,indexDiff=Integer.MIN_VALUE;
        ArrayList<Integer> maxDiff=new ArrayList<>();
        ArrayList<Integer> tenDiff=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int diff=Math.abs(nums[i]-nums[j]);
                if(diff==10 && j-i>indexDiff){
                    tenDiff.clear();
                    tenDiff.add(nums[i]);
                    tenDiff.add(nums[j]);
                    indexDiff=j-i;
                }
                if(diff>maximumDiff && j==i+1){
                    maximumDiff=diff;
                    maxDiff.clear();
                    maxDiff.add(nums[i]);
                    maxDiff.add(nums[j]);
                }
            }
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res.add(maxDiff);
        res.add(tenDiff);
        return res;
    }

    public ArrayList<ArrayList<Integer>> findPairsSorted(int[] nums){
        Arrays.sort(nums);
        ArrayList<Integer> maximDiff=new ArrayList<>();
        maximDiff.add(nums[0]);
        maximDiff.add(nums[nums.length-1]);
        ArrayList<Integer> tenDiff=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[1]==10){
                tenDiff.add(nums[i+1]);
                tenDiff.add(nums[i]);
                break;
            }
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res.add(maximDiff);
        res.add(tenDiff);
        return res;
    }

    public static void main(String[] args) {
        AssignmentOnePartAThree obj=new AssignmentOnePartAThree();
        ArrayList<ArrayList<Integer>> res=obj.findPairsSorted(new int[]{11,111,88,101,181,808,1,818,0});
        Iterator<ArrayList<Integer>> itr=res.iterator();
        while(itr.hasNext()){
            Iterator<Integer> it=itr.next().iterator();
            while(it.hasNext()){
                int el=it.next();
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }
}

//time Complexity: O(n^2)
//space complexity: O(1)

//time Complexity: O(nlogn)
//space complexity: O(1)