package com.graphs;

import java.util.*;

public class SingleSourceShortestPathTopo {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Edge>> adjList = new HashMap<>();
        //0's
        ArrayList<Edge> zeros = new ArrayList<>();
        zeros.add(new Edge(1, 2));
        zeros.add(new Edge(4, 1));
        adjList.putIfAbsent(0, zeros);
        //1's
        ArrayList<Edge> ones = new ArrayList<>();
        ones.add(new Edge(2, 3));
        adjList.putIfAbsent(1, ones);
        //2's
        ArrayList<Edge> twos = new ArrayList<>();
        twos.add(new Edge(3, 6));
        adjList.putIfAbsent(2, twos);
        //3's
        ArrayList<Edge> threes = new ArrayList<>();
        adjList.putIfAbsent(3, threes);
        //4's
        ArrayList<Edge> fours = new ArrayList<>();
        fours.add(new Edge(5, 4));
        fours.add(new Edge(2, 2));
        adjList.putIfAbsent(4, fours);
        //5's
        ArrayList<Edge> fives = new ArrayList<>();
        fives.add(new Edge(3, 1));
        adjList.putIfAbsent(5, fives);

        singleSourceShortestPath(adjList);

    }

    private static void dfs(int src, int[] visited, Stack<Integer> st, HashMap<Integer, ArrayList<Edge>> adjList) {
        visited[src] = 1;
        for (Edge neighbor : adjList.get(src)) {
            if (visited[neighbor.dest] != 1) {
                dfs(neighbor.dest, visited, st, adjList);
            }
        }
        st.push(src);
    }

    public static void singleSourceShortestPath(HashMap<Integer, ArrayList<Edge>> adjList) {
        TreeSet<Integer> nodes = new TreeSet<>(adjList.keySet());
        Integer[] vertices = new Integer[nodes.size()];
        int[] visited = new int[nodes.size()];
        Stack<Integer> st = new Stack<>();
        vertices = nodes.toArray(vertices);
        for (int i = 0; i < vertices.length; ++i) {
            if (visited[vertices[i]] != 1) {
                dfs(vertices[i], visited, st, adjList);
            }
        }
        double[] distances = new double[vertices.length];
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        distances[0] = 0.0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Edge neighbor : adjList.get(node)) {
                distances[neighbor.dest] = Math.min(distances[neighbor.dest], distances[node] + neighbor.weight);
            }
        }
        System.out.println(Arrays.toString(distances));
    }

    static class Edge {
        int dest;
        int weight;

        public Edge(int _dest, int _weight) {
            this.dest = _dest;
            this.weight = _weight;
        }
    }
}
