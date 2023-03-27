package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class KahnsAlgorithmTopologicalSort {
    private static final HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {
        addEdge(5, 0);
        addEdge(5, 2);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(3, 1);
        addEdge(2, 3);
        addEdge(1, -1);
        addEdge(0, -1);
        topologicalSort(6);
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

    //returns vertex with min indegree
    private static int findMin(int[] indeg) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] != -1 && min >= indeg[i]) {
                min = indeg[i];
                idx = i;
            }
        }
        return idx;
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
        q.add(findMin(indeg));
        while (q.size() != 0) {
            int vertex = q.poll();
            indeg[vertex] = -1;
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                indeg[neighbor]--;
            }
            vertex = findMin(indeg);
            if (vertex == -1) break;
            q.add(vertex);
        }

    }

}
