package com.graphs;

public class FloydWarshall {
    final static double INF = Double.POSITIVE_INFINITY, V = 7;

    public static void main(String[] args) {
        double[][] graph = {{0, 5, 7, INF, INF, INF, 16},
                {INF, 0, INF, 5, 3, INF, INF},
                {INF, -2, 0, INF, 3, INF, INF},
                {INF, INF, -3, 0, 0, INF, INF},
                {INF, INF, INF, INF, 0, INF, INF},
                {INF, INF, INF, INF, -1, 0, INF},
                {INF, INF, INF, 6, INF, 2, 0}};
        FloydWarshall obj = new FloydWarshall();

        obj.floydWarshall(graph);
    }

    public void floydWarshall(double[][] cost) {

        int i, j, k;

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
            printSolution(cost,false);
            System.out.println("***************************************");
        }
        printSolution(cost, true);
    }

    void printSolution(double[][] dist, boolean flag) {
        if (flag) System.out.println("The shortest distances between every pair of vertices is given by the matrix:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}