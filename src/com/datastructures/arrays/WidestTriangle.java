package com.datastructures.arrays;

import java.util.*;

public class WidestTriangle {
    public static int widestTriangle(int[] nums){
        int maximumSoFar=Integer.MIN_VALUE;
        int incr=0,decr=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i+1]>nums[i]){
                incr++;
                continue;
            }
            if(nums[i]>nums[i+1]){
                decr++;
                continue;
            }
        }
        return maximumSoFar;
    }
    public static void main(String[] args) {
        System.out.println(widestTriangle(new int[]{0,1,2,3,2,1,0,4,7,6}));
    }
}
