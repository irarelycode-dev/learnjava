package com.datastructures.dp;

import java.util.Arrays;

public class UniquePathsTwo {

    private static int findWays(int[][] mat, int row, int col, int[][] dp) {
        if (row >= 0 && col >= 0 && mat[row][col] == -1) return 0;
        if (row == 0 && col == 0) return 1;
        if (row < 0 || col < 0) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = findWays(mat, row - 1, col, dp) + findWays(mat, row, col - 1, dp);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}};
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(findWays(matrix, matrix.length - 1, matrix[0].length - 1, dp));
    }

}
