package com.graphs;

import java.io.*;
import java.util.*;

class UniqueIslands {
    public static void main(String[] args)
    {

        // Given Inputs
        int[][] grid = { { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };

        // Function Call
        System.out.println("Number of distinct islands is " + countDistinctIslands(grid));
    }

    // 2D array for the storing the horizontal and vertical directions. (Up, left, down, right}
    static int[][] dirs = { { 0, -1 },
            { -1, 0 },
            { 0, 1 },
            { 1, 0 }
    };

    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private static void dfs(int[][] grid, int x0, int y0, int i, int j, ArrayList<String>v) {

        int rows = grid.length, cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] <= 0)
            return;

        // marking the visited element as -1
        grid[i][j] *= -1;

        // computing coordinates with x0, y0 as base
        v.add(toString(i - x0, j - y0));

        // repeat dfs for neighbors
        for (int k = 0; k < 4; k++) {
            dfs(grid, x0, y0, i + dirs[k][0], j + dirs[k][1], v);
        }
    }

    private static void dfs2(int[][] grid,int _r,int _c,int i,int j,ArrayList<String> al){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]>0){
            grid[i][j]*=-1;
            al.add(toString(i-_r,j-_c));
            for(int k=0;k<4;++k){
                dfs(grid,_r,_c,i+dirs[k][0],j+dirs[k][1],al);
            }
        }
    }

    // Main function that returns distinct count of islands in a given boolean 2D matrix
    public static int countDistinctIslands(int[][] grid) {

        HashSet<ArrayList<String>> coordinates = new HashSet<> ();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {

                // If a cell is not 1 no need to dfs
                if (grid[i][j] != 1)
                    continue;

                // vector to hold coordinates of this island
                ArrayList<String> v = new ArrayList<>();
                dfs2(grid, i, j, i, j, v);

                // insert the coordinates for
                // this island to set
                coordinates.add(v);
            }
        }

        return coordinates.size();
    }
}

