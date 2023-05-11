package com.datastructures.dp;

import java.util.Arrays;

public class NStepClimber {
    //time complexity:O(2^n)
    //space complexity:O(n)
    private static int nStepClimber(int n){
        if(n==1||n==2) return n;
        return nStepClimber(n-1)+nStepClimber(n-2);
    }

    //time complexity:O(n),because of optimization, the problem is reduced to a linear problem case
    private static int nSteps(int n,int[] dp){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=nSteps(n-1,dp)+nSteps(n-2,dp);
    }

    public static void main(String[] args) {
        int steps=10;
        int[] dp=new int[steps+1];
        Arrays.fill(dp,-1);
        System.out.println(nSteps(steps,dp));
    }
}

