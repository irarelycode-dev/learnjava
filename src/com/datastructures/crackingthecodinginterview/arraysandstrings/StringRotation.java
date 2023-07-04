package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class StringRotation {
    static boolean isSubstring(String s1, String s2) {
        return s2.contains(s1);
    }

    //tc: O(m*n)- m and n are lengths of s1 and s2
    private static boolean isRotated(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < 2; ++i) {
            sb.append(s2);
        }
        return isSubstring(s1, sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(isRotated("waterbottle", "tlewaterbot"));
    }

}
