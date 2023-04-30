package com.graphs;

import java.util.Arrays;

public class FloydWarshall2 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, 7, INF, INF, INF, 16},
                {INF, 0, INF, 5, 3, INF, INF},
                {INF, -2, 0, INF, 3, INF, INF},
                {INF, INF, -3, 0, 0, INF, INF},
                {INF, INF, INF, INF, 0, INF, INF},
                {INF, INF, INF, INF, -1, 0, INF},
                {INF, INF, INF, 6, INF, 2, 0}
        };
        int n = graph.length;

        int[][] dist = new int[n][n];
        int[][] count = new int[n][n];

        // Step 1: Initialize dist and count arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF) {
                    count[i][j] = 1;
                } else {
                    count[i][j] = 0;
                }
            }
        }

        // Step 3: Compute shortest path distances and number of different shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            count[i][j] = count[i][k] * count[k][j];
                        } else if (dist[i][j] == dist[i][k] + dist[k][j]) {
                            count[i][j] += count[i][k] * count[k][j];
                        }
                    }
                }
            }
        }

        // Step 4: Output dist and count arrays
        System.out.println("Shortest path distances:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        System.out.println("Number of different shortest paths:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(count[i]));
        }
    }
}
