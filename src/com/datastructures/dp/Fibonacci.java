package com.datastructures.dp;

import java.util.*;

public class Fibonacci {

    //time complexity: O(n) due to memoization, there is a linear pattern
    //space complexity: O(n)+O(n) for array and stack space
    private static int fibonacci(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp);
    }

    //tabulation approach-bottom up approach-from base case to required answer
    private static int fibTabulation(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibTabulation(n,dp));
    }
}