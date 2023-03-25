package com.graphs;

import java.util.*;

public class PathsFinding {
    private static final Set<ArrayList<Integer>> paths = new HashSet<>();
    private static final Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    private static void addEdge(int src, int dest) {
        ArrayList<Integer> neighbors;
        if (!adjList.containsKey(src)) {
            neighbors = new ArrayList<>();
            adjList.put(src, neighbors);
        } else neighbors = adjList.get(src);
        neighbors.add(dest);
    }

    private static void allPaths(int src, int curr, int dest, int[] visited, ArrayList<Integer> path) {
        if (curr == dest && curr != src) {
            path.add(0, src);
            paths.add(path);
            path.remove(0);
            return;
        }
        visited[curr] = 1;
        List<Integer> neighbors = adjList.get(curr);
        if (neighbors == null) return;
        for (Integer neighbor : neighbors) {
            if (visited[neighbor] != 1) {
                path.add(neighbor);
                allPaths(src, neighbor, dest, visited, path);
                path.remove(neighbor);
            }
        }
        visited[curr] = 0;
    }

    public static void main(String[] args) {
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 4);
        addEdge(2, 5);
        addEdge(4, 5);
        addEdge(3, 6);
        addEdge(5, 7);
        addEdge(6, 7);
        int[] visited = new int[8];
        allPaths(1, 1, 5, visited, new ArrayList<>());
        Iterator<ArrayList<Integer>> itr = paths.iterator();
        while (itr.hasNext()) {
            ArrayList<Integer> tmp = itr.next();
        }
    }

}
