package com.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Nearest01 {
    static class Triplet{
        int x;
        int y;
        int dist;
        Triplet(int _x,int _y,int _dist){
            x=_x;
            y=_y;
            dist=_dist;
        }
    }

    public static void nearest01Util(int[][] adjMatrix,Queue<Triplet> queue,int[][] distances,int[][] visited){
        int[] xMoves={-1,0,+1,0};
        int[] yMoves={0,+1,0,-1};
        while(queue.size()!=0){
            Triplet tmp=queue.poll();
            distances[tmp.x][tmp.y]=tmp.dist;
            for(int i=0;i<4;++i){
                int x=tmp.x+xMoves[i];
                int y=tmp.y+yMoves[i];
                if(x>=0 && x<adjMatrix.length && y>=0 && y<adjMatrix[0].length && visited[x][y]!=1){
                    queue.add(new Triplet(x,y,tmp.dist+1));
                    visited[x][y]=1;
                }
            }
        }
    }

    public static void nearest01(int[][] adjMatrix){
        int[][] visited=new int[adjMatrix.length][adjMatrix[0].length];
        int[][] distances=new int[adjMatrix.length][adjMatrix[0].length];
        Queue<Triplet> q=new ArrayDeque<>();
        for(int i=0;i<adjMatrix.length;++i){
            for(int j=0;j<adjMatrix[0].length;++j){
                if(adjMatrix[i][j]==1){
                    q.add(new Triplet(i,j,0));
                    visited[i][j]=1;
                }
            }
        }
        nearest01Util(adjMatrix,q,distances,visited);

        for(int i=0;i<distances.length;++i){
            System.out.println(Arrays.toString(distances[i]));
        }
    }

    public static void main(String[] args) {
        int[][] adjMatrix={{0,0,0},{0,1,0},{1,0,1}};
        nearest01(adjMatrix);
    }

}
