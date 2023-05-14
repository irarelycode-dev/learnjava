package com.datastructures.dp;

import java.util.Arrays;

public class MaximumJumpSum {
    private static int maxSum(int[] nums,int k){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<nums.length;++i){
            int tmp=Integer.MIN_VALUE;
            for(int j=1;j<=k;++j){
                if(i-j>=0) tmp=Math.max(tmp,nums[i]+dp[i-j]);
            }
            dp[i]=tmp;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums={1,-5,-20,4,-1,3,-6,-3};
        System.out.println(maxSum(nums,2));
    }
}
