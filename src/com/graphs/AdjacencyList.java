package com.graphs;

import java.util.*;

public class AdjacencyList {
    static List<Integer>[] adj;
    static int n,m;
    static Scanner s=new Scanner(System.in);

    static void printAdjList(){
        for(int i=0;i<m;i++){
            System.out.println(adj[i]);
        }
    }

    public static void main(String[] args) {
        int[] input=Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n=input[0];
        m=input[1];
        //space complexity will be O(2E)
        adj=new LinkedList[n+1];
        for(int i=0;i<m;i++){
            int[] edge=Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(adj[edge[0]]==null) adj[edge[0]]=new LinkedList<>();
            if(adj[edge[1]]==null) adj[edge[1]]=new LinkedList<>();
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        printAdjList();
    }
}
