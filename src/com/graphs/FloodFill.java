package com.graphs;

import java.util.Arrays;

public class FloodFill {

    private static void dfs(int row,int col,int[][] copy,int newColor,int initColor,int[] nRow,int[] nCol){
        copy[row][col]=newColor;
        int n=copy.length;
        int m=copy[0].length;
        for(int i=0;i<4;++i){
            int neighborRow=row+nRow[i];
            int neighborCol=col+nCol[i];
            if(neighborRow>=0 && neighborRow<n && neighborCol>=0 && neighborCol<m && copy[neighborRow][neighborCol]==initColor){
                dfs(neighborRow,neighborCol,copy,newColor,initColor,nRow,nCol);
            }
        }
    }

    public static void dfs(int[][] image,int sr,int sc,int color,int[] nRow,int[] nCol,int initColor){
        image[sr][sc]=color;
        for(int i=0;i<4;++i){
            int neighborRow=sr+nRow[i];
            int neighborCol=sc+nCol[i];
            if(neighborRow>=0 && neighborRow<image.length && neighborCol>=0 && neighborCol<image[0].length && image[neighborRow][neighborCol]==initColor){
                dfs(image,neighborRow,neighborCol,color,nRow,nCol,initColor);
            }
        }
    }


    public static void main(String[] args) {
        int[][] adjMatrix={{1,1,1},{1,1,0},{1,0,1}};
        int newColor=2;
        int initColor=adjMatrix[1][1];
        dfs(adjMatrix,1,1,2,new int[]{-1,0,1,0},new int[]{0,1,0,-1},initColor);
    }

}
