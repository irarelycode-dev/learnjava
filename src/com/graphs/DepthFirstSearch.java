package com.graphs;
import java.util.*;

class Graph{
    private int V;
    private HashMap<Integer,LinkedList<Integer>> hm=new HashMap<>();
    public Graph(int v){
        this.V=v;
        for(int i=0;i<v;i++){
            this.hm.put(i,new LinkedList<Integer>());
        }
    }
    void addEdge(int v, int w){
        this.hm.get(v).add(w);
    }
    void dfs(int source,boolean[] visited){
        visited[source]=true;
        System.out.print(source+" ");
        LinkedList<Integer> curr=hm.get(source);
        Iterator<Integer> itr=curr.iterator();
        while(itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) dfs(n, visited);
        }
    }
}

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph=new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        boolean[] visited=new boolean[4];
        graph.dfs(0,visited);
    }
}
