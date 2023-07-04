package com.datastructures.crackingthecodinginterview.arraysandstrings;

import java.util.*;

public class RotateImage {
    //tc:O(N)
    //sc:O(1)
    public static void rotateMatrix(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        for (int[] row : matrix) {
            reverseRow(row);
        }
    }

    private static void reverseRow(int[] row) {
        int ptr1 = 0, ptr2 = row.length - 1;
        while (ptr1 <= ptr2) {
            int tmp = row[ptr1];
            row[ptr1] = row[ptr2];
            row[ptr2] = tmp;
            ptr1++;
            ptr2--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
