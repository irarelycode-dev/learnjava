package com.datastructures.dp;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumSumOfNonAdjacentElements {
    private static int maxSumUtil(int[] nums,int index,int[] dp){
        if(index==0) return nums[index];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick=nums[index]+maxSumUtil(nums,index-2,dp);
        int notPick=0+maxSumUtil(nums,index-1,dp);
        return dp[index]=Math.max(pick,notPick);
    }
    private static int maximumSumOfNonAdjacentElements(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return maxSumUtil(nums,nums.length-1,dp);
    }

    private static int maximumSumTabulationMethod(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;++i){
            int pick=nums[i];
            if(i>1) pick+=dp[i-2];
            int notPick=0+dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums={5, 20, 15, -2, 18};
        System.out.println(maximumSumOfNonAdjacentElements(nums));
        System.out.println(maximumSumTabulationMethod(nums));
    }
}
