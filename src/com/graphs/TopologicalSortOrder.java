package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSortOrder {
    static HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    private static void addEdge(int src, int dest) {
        ArrayList<Integer> neighbors;
        if (!adjList.containsKey(src)) {
            neighbors = new ArrayList<>();
            adjList.put(src, neighbors);
            if (dest == -1) return;
        } else {
            neighbors = adjList.get(src);
        }
        neighbors.add(dest);
    }

    public static void main(String[] args) {
        addEdge(1, 0);
        addEdge(2, 0);
        addEdge(3, 0);
        addEdge(4, 0);
        addEdge(0, -1);
        Object[] res = topologicalSort(5);
        for (int i = res.length - 1; i >= 0; --i) {
            System.out.print(res[i] + " ");
        }
    }

    static void dfs(int src, int[] visited, Stack<Integer> s) {
        visited[src] = 1;
        for (int node : adjList.get(src)) {
            if (visited[node] != 1) {
                visited[node] = 1;
                dfs(node, visited, s);
            }
        }
        s.add(src);
    }

    public static Object[] topologicalSort(int v) {
        int[] visited = new int[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            dfs(i, visited, st);
        }
        return st.toArray();
    }
}
