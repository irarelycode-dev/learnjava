package com.datastructures.two_pointers;


import java.util.*;

public class PancakeFlipping {
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = arr.length - 1; i > 0; i--) {
            int largestNumberIndex = findIndex(arr, i);
            if (largestNumberIndex != i) {
                flip(arr, largestNumberIndex);
                flip(arr, i);
                list.add(largestNumberIndex + 1);
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void flip(int[] arr, int k) {
        int i = 0;
        int j = k;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static int findIndex(int[] arr, int k) {
        int index = k;
        for (int i = k - 1; i >= 0; i--) {
            if (arr[i] > arr[index]) index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 1};
        List<Integer> result = pancakeSort(a);
        for (Integer flipIndx : result) {
            System.out.print(flipIndx + " ");
        }
    }

}
