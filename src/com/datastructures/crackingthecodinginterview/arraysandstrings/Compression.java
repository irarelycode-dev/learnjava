package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class Compression {
    //tc:O(N)
    //sc:O(2*N)
    private static String compress(String s1) {
        char prev = s1.charAt(0);
        int len = s1.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < len; ++i) {
            char ch = s1.charAt(i);
            if (ch != prev) {
                sb.append(prev + "" + count);
                count = 1;
                prev = ch;
            } else {
                count++;
                if (len - 1 == i) sb.append(ch + "" + count);
            }
        }
        return sb.length() >= len ? s1 : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("abcd"));
    }
}
