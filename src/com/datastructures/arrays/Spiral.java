package com.datastructures.arrays;

import java.util.*;

public class Spiral {
    public static List<Integer> spiralOrder(int[][] matrix){
        int[] directions={0,1,2,3};
        int start=directions[0];
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        List<Integer> res=new ArrayList<>();
        while(top<=bottom && left<=right){
            switch(start){
                case 0:
                    for(int i=left;i<=right;i++){
                        res.add(matrix[top][i]);
                    }
                    top++;
                    start=directions[1];
                    break;
                case 1:
                    for(int i=top;i<=bottom;i++){
                        res.add(matrix[i][right]);
                    }
                    right--;
                    start=directions[2];
                    break;
                case 2:
                    for(int i=right;i>=left;i--){
                        res.add(matrix[bottom][i]);
                    }
                    bottom--;
                    start=directions[3];
                    break;
                case 3:
                    for(int i=bottom;i>=top;i--){
                        res.add(matrix[i][left]);
                    }
                    left++;
                    start=directions[0];
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2},{3,4},{5,6}};
        spiralOrder(matrix);
    }
}
