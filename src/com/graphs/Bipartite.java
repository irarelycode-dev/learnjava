package com.graphs;

import java.util.*;

public class Bipartite {
    private static final HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    private static void addEdge(int src, int dest) {
        ArrayList<Integer> neighbors;
        if (!adjList.containsKey(src)) {
            neighbors = new ArrayList<>();
            if (dest != -1) neighbors.add(dest);
            adjList.put(src, neighbors);
            return;
        }
        neighbors = adjList.get(src);
        neighbors.add(dest);
    }

    public static void main(String[] args) {
        addEdge(1, 2);
        addEdge(2, 1);
        addEdge(2, 3);
        addEdge(2, 6);
        addEdge(3, 4);
        addEdge(3, 2);
        addEdge(4, 5);
        addEdge(4, 3);
        addEdge(4, 7);
        addEdge(5, 6);
        addEdge(5, 4);
        addEdge(6, 5);
        addEdge(6, 2);
        addEdge(7, 8);
        addEdge(7, 4);
        addEdge(8, 7);
        System.out.println(isBipartite(1));
    }

    static boolean isBipartite(int src) {
        int[] visited = new int[9];
        int[] colors = new int[9];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= 8; i++) {
            if (colors[i] == -1) {
                if (!bfs(1, visited, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int src, int[] visited, int[] colors) {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(src);
        visited[src] = 1;
        colors[src] = 1;
        while (!q.isEmpty()) {
            src = q.poll();
            ArrayList<Integer> neighbors = adjList.get(src);
            for (int neighbor : neighbors) {
                if (visited[neighbor] != 1) {
                    if (colors[neighbor] == -1) {
                        visited[neighbor] = 1;
                        q.add(neighbor);
                        colors[neighbor] = colors[src] == 1 ? 0 : 1;
                        List<Integer> subNeighbors = adjList.get(neighbor);
                        for (int subNeighbor : subNeighbors) {
                            if (colors[subNeighbor] == colors[neighbor]) return false;
                        }
                    } else if (colors[neighbor] == colors[src]) return false;
                }
            }
        }
        return true;
    }
}
