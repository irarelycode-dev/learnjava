package com.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class GraphInput {
    static Scanner s=new Scanner(System.in);
    static int n,m;
    static int[][] adj;
    static void printAdjacency(){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(adj[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] input= Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n=input[0];
        m=input[1];
        //space complexity: O(nxn)
        adj=new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int[] edge=Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[edge[0]][edge[1]]=1;
            adj[edge[1]][edge[0]]=1;
        }
        printAdjacency();
    }
}
