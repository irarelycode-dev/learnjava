package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class PalindromePermutation {
    //tc: O(N)
    //sc: O(256)
    private static boolean palindromicPermutation(String s1) {
        int[] frequency = new int[256];
        int len = s1.length();
        int space = 0;
        for (int i = 0; i < len; ++i) {
            char ch = Character.toLowerCase(s1.charAt(i));
            if (ch != ' ') {
                frequency[(int) ch] += 1;
            } else {
                space++;
            }
        }
        int count = 0;
        for (int i = 0; i < 256; ++i) {
            if (frequency[i] % 2 == 0) count += frequency[i];
        }
        return count == len - space || count == len - space - 1;
    }

    public static void main(String[] args) {
        System.out.println(palindromicPermutation("Malayalam"));
    }
}
