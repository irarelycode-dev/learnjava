package com.datastructures.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//O(n^2)
public class LongestIncreasingSubsequence {
    static int longestIncreasingSubsequence(int[] a){
        int[] dp=new int[a.length];
        int[] previous=new int[a.length];
        List<Integer> res=new LinkedList<>();
        Arrays.fill(dp,1);
        for(int i=0;i<a.length;i++) {
            int m = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] > m) {
                    m = dp[j];
                    previous[i]=j;
                }
            }
            dp[i] = 1 + m;
        }
        int max=Integer.MIN_VALUE;
        int pos=-1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
                pos=i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a={5,2,8,6,3,6,9,7};
        System.out.println(longestIncreasingSubsequence(a));
    }

}
