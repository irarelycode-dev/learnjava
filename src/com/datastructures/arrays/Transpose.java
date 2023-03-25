package com.datastructures.arrays;

public class Transpose {
    private static void swap(int i,int j,int[][] matrix){
        int tmp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=tmp;
    }
    private static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void transposeMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                swap(i,j,matrix);
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        System.out.println("*****************");
        transposeMatrix(matrix);
        printMatrix(matrix);
    }
}
