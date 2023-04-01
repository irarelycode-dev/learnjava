package com.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstras {
    public static int[] singleSourceShortest(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] dist = new int[V];
        for (int i = 0; i < V; ++i) dist[i] = (int) (1e6);
        dist[src] = 0;
        pq.add(new Pair(0, 5));
        while (!pq.isEmpty()) {
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adjList.get(node).size(); ++i) {
                int edgeWeight = adjList.get(node).get(i).get(1);
                int neighborNode = adjList.get(node).get(i).get(0);
                if (dis + edgeWeight < dist[neighborNode]) {
                    dist[neighborNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[neighborNode], neighborNode));
                }
            }
        }
        return dist;
    }

    static class Pair {
        int dist;
        int node;

        public Pair(int _dist, int _node) {
            dist = _dist;
            node = _node;
        }
    }
}
