package com.datastructures.dp;

import java.util.*;

public class Fibonacci {
    private static int fibonacci(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibonacci(n,dp));
    }
}