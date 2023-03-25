package com.graphs;

import java.util.*;

class Node{
    int x;
    int y;
    int t;
    public Node(int x,int y,int t){
        this.x=x;
        this.y=y;
        this.t=t;
    }
}

public class RottenTomatoes {
    static int tmax;
    static Queue<Node> q;
    static Scanner s=new Scanner(System.in);

    static int bfs(int[][] adj,int[][] visited){
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(q.size()!=0){
            Node n=q.remove();
            tmax=Math.max(tmax,n.t);
            for(int i=0;i<4;i++){
                int nRow=dRow[i]+n.x;
                int nCol=dCol[i]+n.y;
                if(nRow>=0 && nRow<=adj.length-1 && nCol>=0 && nCol<=adj[0].length-1 && visited[nRow][nCol]!=2 && adj[nRow][nCol]==1){
                    Node tmp=new Node(nRow,nCol,n.t+1);
                    q.add(tmp);
                    visited[nRow][nCol]=2;
                }
            }
        }
        return tmax;
    }

    public static void main(String[] args) {
        int[] ip=Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=ip[0];
        int m=ip[1];
        int[][] adj=new int[n][m];
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            ip=Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[i]=ip;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(adj[i][j]==2){
                    visited[i][j]=2;
                    q.add(new Node(i,j,0));
                }
            }
        }
        System.out.println(bfs(adj,visited));
    }
}
