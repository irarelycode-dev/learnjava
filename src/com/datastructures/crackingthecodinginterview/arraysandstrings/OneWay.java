package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class OneWay {
    //tc:O(s1) || O(s2)
    //sc:O(256)
    private static boolean oneWay(String s1, String s2) {
        int[] chars = new int[256];
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            chars[(int) s1.charAt(i)] += 1;
        }
        for (int i = 0; i < s2.length(); ++i) {
            chars[(int) s2.charAt(i)] -= 1;
        }
        for (int i = 0; i < 256; i++) {
            if (chars[i] > 0) count++;
        }
        return count == 0 || count == 1;
    }

    public static void main(String[] args) {
        System.out.println(oneWay("pale", "ple"));
        System.out.println(oneWay("pale", "bake"));
    }
}
