package com.datastructures.dp;

import java.util.Arrays;

public class MinimumPathSum {

    private static int minimumSumPath(int[][] mat, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return mat[i][j];
        if (i >= 0 && j >= 0 && dp[i][j] != -1) return dp[i][j];
        else if (i == 0) return mat[0][j] + minimumSumPath(mat, 0, j - 1, dp);
        else if (j == 0) return mat[i][0] + minimumSumPath(mat, i - 1, 0, dp);
        return dp[i][j] = Math.min(mat[i][j] + minimumSumPath(mat, i - 1, j, dp), mat[i][j] + minimumSumPath(mat, i, j - 1, dp));
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] a : dp) Arrays.fill(a, -1);
        System.out.println(minimumSumPath(matrix, matrix.length - 1, matrix[0].length - 1, dp));
    }

}
