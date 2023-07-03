package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class FirstUniqueCharacter {
    private static Character findUniqueChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            freq[ch - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[(int) (ch - 'a')] == 1) return ch;
        }
        return Character.valueOf('-');
    }

    public static void main(String[] args) {
        System.out.println(findUniqueChar("cchennaisuperkingsh")); //no space allowed
    }
}
