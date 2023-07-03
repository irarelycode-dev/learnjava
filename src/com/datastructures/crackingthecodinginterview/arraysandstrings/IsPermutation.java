package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class IsPermutation {
    //tc: O(N)
    //sc: O(1)
    private static boolean checkIfPermutation(String s1, String s2) {
        int[] chars = new int[256];
        for (char ch : s1.toCharArray()) {
            chars[(int) ch] += 1;
        }
        for (char ch : s2.toCharArray()) {
            chars[(int) ch] -= 1;
        }
        for (int num : chars) {
            if (num > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPermutation("che 2 3", "  32ehc"));
    }
}
