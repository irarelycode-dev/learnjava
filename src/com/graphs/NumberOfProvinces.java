package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfProvinces {
    static HashMap<Integer, ArrayList<Integer>> adjList= new HashMap<>();
    private static void addEdge(int src,int dest){
        if(!adjList.containsKey(src)){
            ArrayList<Integer> neighbors=new ArrayList<>();
            neighbors.add(dest);
            adjList.putIfAbsent(src,neighbors);
            return;
        }
        adjList.get(src).add(dest);
    }

    static void bfs(int vertex,boolean[] visited){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(vertex);
        visited[vertex]=true;
        while(queue.size()!=0){
            int tmp=queue.poll();
            for (int neighbor:adjList.get(tmp)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
    }

    static int numberOfProvinces(int v){
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        int count=0;
        for(int i=0;i<v;++i){
            if(!visited[i]){
                count++;
                bfs(i,visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int v=8;
        addEdge(0,1);
        addEdge(1,0);
        addEdge(1,2);
        addEdge(2,1);

        addEdge(3,4);
        addEdge(4,3);
        addEdge(4,5);
        addEdge(5,4);

        addEdge(6,7);
        addEdge(7,6);

        System.out.println(numberOfProvinces(v));

    }

}
