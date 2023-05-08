package com.graphs;

import java.util.*;

public class Nearest0 {
    static class Triplet{
        int x;
        int y;
        int dist;
        Triplet(int _x,int _y,int _dist){
            this.x=_x;
            this.y=_y;
            this.dist=_dist;
        }
        @Override
        public String toString(){
            return "("+x+","+y+","+dist+")";
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] visited=new int[mat.length][mat[0].length];
        int[][] distances=new int[mat.length][mat[0].length];
        Queue<Triplet> queue=new ArrayDeque<>();
        for(int i=0;i<mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j]==0){
                    queue.add(new Triplet(i,j,0));
                    visited[i][j]=1;
                    distances[i][j]=0;
                }
            }
        }
        int[] x={-1,0,+1,0};
        int[] y={0,+1,0,-1};
        while(queue.size()!=0){
            Triplet tmp=queue.poll();
            System.out.println(tmp);
            for(int i=0;i<4;++i){
                int xMove=tmp.x+x[i];
                int yMove=tmp.y+y[i];
                if(xMove>=0&&xMove<mat.length&&yMove>=0&&yMove<mat[0].length&&visited[xMove][yMove]!=1){
                    queue.add(new Triplet(xMove,yMove,tmp.dist+1));
                    visited[xMove][yMove]=1;
                    distances[xMove][yMove]=tmp.dist+1;
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        int[][] adjMatrix={{0,0,0},{0,1,0},{0,0,0}};
        int[][] result=updateMatrix(adjMatrix);
        for(int i=0;i<result.length;++i){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
