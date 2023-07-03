package com.datastructures.crackingthecodinginterview.arraysandstrings;

public class Urlify {
    private static String urlify(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlify(" Some random string with space"));
    }
}
