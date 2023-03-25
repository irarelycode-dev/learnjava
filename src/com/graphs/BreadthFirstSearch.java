package com.graphs;

import java.io.*;
import java.util.*;

public class BreadthFirstSearch {

    private int V;
    private LinkedList<Integer> adj[];

    BreadthFirstSearch(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    void addEdge(int v,int w){
        adj[v].add(w);
    }

    void BFS(int s){
        boolean[] visited=new boolean[V];
        LinkedList<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(queue.size()!=0){
            s=queue.poll();
            Iterator<Integer> itr=adj[s].iterator();
            while(itr.hasNext()){
                int node=itr.next();
                if(!visited[node]){
                    visited[node]=true;
                    queue.add(node);
                }
            }
        }
    }

}
