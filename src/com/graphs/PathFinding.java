package com.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class PathFinding {
    private static final Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    private static Stack<Integer> path=new Stack<>();

    private static void addEdge(int src, int dest) {
        LinkedList<Integer> neighbors;
        if (!adjList.containsKey(src)) {
            neighbors = new LinkedList<>();
            adjList.put(src, neighbors);
        }else neighbors= adjList.get(src);
        neighbors.add(dest);
    }

    public static void dfs(int src,int curr, int dest, int[] visited) {
        visited[curr] = 1;
        path.add(curr);
        if(curr==dest && curr!=src){
            System.out.println(path);
            return;
        }
        LinkedList<Integer> neighbors = adjList.get(curr);
        for (Integer neighbor : neighbors) {
            if (visited[neighbor] != 1 && visited[dest]!=1) {
                dfs(src,neighbor, dest, visited);
                path.pop();
            }
        }
        visited[curr]=0;
    }

    public static void main(String[] args) {
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,4);
        addEdge(3,4);
        addEdge(2,5);
        addEdge(4,5);
        addEdge(3,6);
        addEdge(5,7);
        addEdge(6,7);
        int[] visited=new int[8];
        dfs(1,1,5,visited);
    }
}
