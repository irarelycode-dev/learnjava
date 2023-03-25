package com.graphs;

import java.util.*;

class Vertex{
    int val;
    List<Vertex> neighbors;
    Vertex(int _val,List<Vertex> _neighbors){
        val=_val;
        neighbors=_neighbors;
    }
    Vertex(int _val){
        val=_val;
    }
    void addNeighbors(List<Vertex> _neighbors){
        neighbors=_neighbors;
    }
}

public class CycleDetection {
    public static boolean hasCycle(Vertex n){
        Queue<Vertex> q=new LinkedList<>();
        Map<Vertex,Vertex> hm=new HashMap<>();
        q.add(n);
        hm.put(n,null);
        while(q.size()!=0){
            Vertex tmp=q.remove();
            for(Vertex neighbor:tmp.neighbors) {
                if (!hm.containsKey(neighbor)) {
                    hm.put(neighbor, tmp);
                    q.add(neighbor);
                } else {
                    System.out.println("Reached from: " + hm.get(neighbor).val);
                    return true;
                }
            }
        }
        return false;
    }

    static Map<Vertex,Vertex> hm=new HashMap<>();
    public static void hasCycleDfs(Vertex n){
        if(n.neighbors!=null) {
            for (Vertex neighbor : n.neighbors) {
                if (!hm.containsKey(neighbor)) {
                    hm.put(neighbor, n);
                    hasCycleDfs(neighbor);
                } else {
                    System.out.println("Previously visited from: " + hm.get(neighbor).val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);
        Vertex v4=new Vertex(4);
        Vertex v5=new Vertex(5);
        Vertex v6=new Vertex(6);
        Vertex v7=new Vertex(7);
        v1.addNeighbors(Arrays.asList(v3,v2));
        v2.addNeighbors(Arrays.asList(v5));
        v3.addNeighbors(Arrays.asList(v6,v4));
        v4.addNeighbors(Arrays.asList());
        v5.addNeighbors(Arrays.asList(v7));
        v6.addNeighbors(Arrays.asList(v7));
        System.out.println(hasCycle(v1));
        hasCycleDfs(v1);
    }
}
