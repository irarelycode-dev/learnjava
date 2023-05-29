package com.datastructures.dp;

import java.util.Arrays;

public class NinjaTraining {
    private static int maximumNinjaGain(int[][] tasks, int day, int lastTask, int[][] dp) {
        if (day == 0) {
            int[] dayTasks = tasks[day];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dayTasks.length; ++i) {
                if (i != lastTask) {
                    max = Math.max(max, dayTasks[i]);
                }
            }
            return max;
        }
        if (lastTask != -1) {
            if (dp[day][lastTask] != -1) return dp[day][lastTask];
        }
        int[] dayTasks = tasks[day];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dayTasks.length; ++i) {
            if (i != lastTask) {
                int points = dayTasks[i] + maximumNinjaGain(tasks, day - 1, i, dp);
                max = Math.max(max, points);
            }
        }
        if (lastTask != -1) dp[day][lastTask] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] tasks = {{2, 1, 3}, {3, 4, 6}, {10, 1, 6}, {8, 3, 7}};
        int day = tasks.length - 1;
        int[][] dp = new int[tasks.length][4];
        for (int i = 0; i < dp.length; ++i) Arrays.fill(dp[i], -1);
        System.out.println(maximumNinjaGain(tasks, day, -1, dp));
    }
}
