package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class UniqueChars {
    private static boolean uniqueChars(String s) {
        int bitsetLower = 0;
        int bitsetUpper = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                int codePoint = ch - 'A';
                if ((bitsetUpper & (1 << codePoint)) > 0) return false;
                bitsetUpper = bitsetUpper | (1 << codePoint);
            } else {
                int codePoint = ch - 'a';
                if ((bitsetLower & (1 << codePoint)) > 0) return false;
                bitsetLower = bitsetLower | (1 << codePoint);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueChars("VignesSSh"));
    }
}
