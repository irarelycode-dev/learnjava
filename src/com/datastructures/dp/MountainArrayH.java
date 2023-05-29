package com.datastructures.dp;

import java.util.Arrays;

public class MountainArrayH {
    private static int minRemovalsForMountainArray(int[] a) {
        int[] dp1 = new int[a.length];
        int[] dp2 = new int[a.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < a.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (a[i] > a[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = a.length - 2; i >= 0; --i) {
            for (int j = a.length - 1; j > i; --j) {
                if (a[i] > a[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < a.length - 1; ++i) {
            if (dp2[i] > 1 && dp1[i] > 1) {
                max = Math.max(max, dp1[i] + dp2[i] - 1);
            }
        }
        return a.length - max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minRemovalsForMountainArray(arr));
    }

}
