package com.datastructures.arrays;

import java.util.*;

import static java.lang.System.*;

public class CountAndSay {
    static class Node {
        char key;
        int value;

        Node(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static String countAndSayUtil(int n, String s) {
        if (n == 1) return "1";
        String res = countAndSayUtil(n - 1, s);
        List<Node> list = new LinkedList<>();
        for (int i = 0; i < res.length(); ) {
            int count = 0;
            char tmp = res.charAt(i);
            for (int j = i; j < res.length(); ++j) {
                if (res.charAt(i) == res.charAt(j)) {
                    count++;
                } else {
                    j = res.length();
                }
            }
            i = i + count;
            list.add(new Node(tmp, count));
        }
        String tmp = "";
        for (Node node : list) {
            tmp += node.value + "" + node.key;
        }
        return tmp;
    }

    public static void main(String[] args) {
        out.println(countAndSayUtil(5, ""));
    }
}
