package com.datastructures;

public class InDegreeOfATree {
    public int[] inDegree(int n,int[] left,int[] right){
        int[] indegree=new int[n];
        for(int i=0;i<left.length;i++){
            if(left[i]!=-1){
                indegree[left[i]]++;
            }
        }
        for(int i=0;i<right.length;i++){
            if(right[i]!=-1){
                indegree[right[i]]++;
            }
        }
        return indegree;
    }
    public static void main(String[] args) {

    }
}
