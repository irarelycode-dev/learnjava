package com.datastructures.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//O(n^2)
public class LongestIncreasingSubsequence {
    static int longestIncreasingSubsequence(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static int longestDecreasingSubsequence(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (a[i] < a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(longestIncreasingSubsequence(a));
        System.out.println(longestDecreasingSubsequence(a));
    }

}
