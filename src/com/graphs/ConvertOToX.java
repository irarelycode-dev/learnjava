package com.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ConvertOToX {
    static class Point{
        int x;
        int y;
        Point(int _x,int _y){
            this.x=_x;
            this.y=_y;
        }
    }

    private static void dfs(int x,int y,int[][] canBeChanged,char[][] adjMatrix,int[] xMove,int[] yMove){
        canBeChanged[x][y]=1;
        for(int i=0;i<4;++i){
            int tmpX=x+xMove[i];
            int tmpY=y+yMove[i];
            if(tmpX>=0 && tmpX<canBeChanged.length && tmpY>=0 && tmpY<canBeChanged[0].length && adjMatrix[tmpX][tmpY]=='O' && canBeChanged[tmpX][tmpY]==0){
                dfs(tmpX,tmpY,canBeChanged,adjMatrix,xMove,yMove);
            }
        }
    }

    public static void convertOToX(char[][] adjMatrix){
        Queue<Point> q=new ArrayDeque<>();
        int[][] canBeChanged=new int[adjMatrix.length][adjMatrix[0].length];
        for(int i=0;i<adjMatrix.length;++i) {
            for (int j = 0; j < adjMatrix[0].length; ++j) {
                if (adjMatrix[i][j] == 'O' && (i == 0 || i == adjMatrix.length - 1 || j == 0 || j == adjMatrix[0].length-1)) {
                    q.add(new Point(i, j));
                }
            }
        }

        int[] xMove={-1,0,+1,0};
        int[] yMove={0,+1,0,-1};
        while(q.size()!=0){
            Point tmp=q.poll();
            dfs(tmp.x,tmp.y,canBeChanged,adjMatrix,xMove,yMove);
        }

        for(int i=0;i<adjMatrix.length;++i){
            for(int j=0;j<adjMatrix[0].length;++j){
                if(canBeChanged[i][j]==0 && adjMatrix[i][j]=='O'){
                    adjMatrix[i][j]='X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char x='X';
        char o='O';
        char[][] adjMatrix={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        convertOToX(adjMatrix);
        for(int i=0;i<adjMatrix.length;++i){
            System.out.println(Arrays.toString(adjMatrix[i]));
        }
    }

}
