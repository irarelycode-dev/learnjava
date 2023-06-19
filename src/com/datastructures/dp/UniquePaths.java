package com.datastructures.dp;

import java.util.Arrays;

public class UniquePaths {
    private static int uniquePaths(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = uniquePaths(row - 1, col, dp) + uniquePaths(row, col - 1, dp);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0}, {0, 0}, {0, 0}};
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        System.out.println(uniquePaths(matrix.length - 1, matrix[0].length - 1, dp));
    }
}
