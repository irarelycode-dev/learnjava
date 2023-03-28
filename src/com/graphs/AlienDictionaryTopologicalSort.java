package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class AlienDictionaryTopologicalSort {
    public static void main(String[] args) {
        getAlphabeticalOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"});
    }

    public static void getAlphabeticalOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> adjList = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; ++j) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    ArrayList<Character> neighbors = adjList.getOrDefault(s1.charAt(j), new ArrayList<>());
                    neighbors.add(s2.charAt(j));
                    adjList.putIfAbsent(s1.charAt(j), neighbors);
                    break;
                }
            }
        }

        for (int i = 97; i <= 100; ++i) {
            if (!adjList.containsKey((char) i)) {
                adjList.put((char) i, new ArrayList<>());
            }
        }

        //topological sort
        Character[] nodes = adjList.keySet().toArray(new Character[0]);
        HashMap<Character, Integer> indegree = new HashMap<>();
        Queue<Character> q = new PriorityQueue<>();


        //calculate indegree of each vertex
        for (int i = 0; i < nodes.length; ++i) {
            int count = 0;
            for (int j = 0; j < nodes.length; ++j) {
                if (i != j && adjList.get(nodes[j]).contains(nodes[i])) count++;
            }
            indegree.putIfAbsent(nodes[i], count);
            if (count == 0 && q.size() == 0) q.add(nodes[i]);
        }

        while (q.size() != 0) {
            char tmp = q.poll();
            indegree.put(tmp, -1);
            System.out.print(tmp + " ");
            for (Character neighbor : adjList.get(tmp)) {
                int degree = indegree.get(neighbor);
                indegree.put(neighbor, degree - 1);
                if (indegree.get(neighbor) == 0) q.add(neighbor);
            }
        }
    }
}
