package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class KahnsAlgorithmTopologicalSort {
    private static final HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 0);
        topologicalSort(4);
    }

    private static void addEdge(int src, int dest) {
        ArrayList<Integer> neighbors;
        if (!adjList.containsKey(src)) {
            neighbors = new ArrayList<>();
            if (dest != -1) neighbors.add(dest);
            adjList.put(src, neighbors);
        } else {
            neighbors = adjList.get(src);
            neighbors.add(dest);
        }
    }

    public static void topologicalSort(int v) {
        int[] indeg = new int[v];
        Integer[] vertices = adjList.keySet().toArray(new Integer[0]);

        //calculates indegree of each vertex in graph G
        for (int i = 0; i < vertices.length; ++i) {
            int count = 0;
            for (int j = 0; j < vertices.length; ++j) {
                if (j != i && adjList.get(j).contains(i)) count++;
            }
            indeg[i] = count;
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < v; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (q.size() != 0) {
            int vertex = q.poll();
            indeg[vertex] = -1;
            res.add(vertex);
            for (int neighbor : adjList.get(vertex)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) q.add(neighbor);
            }
        }

        System.out.println(res);

    }

}
