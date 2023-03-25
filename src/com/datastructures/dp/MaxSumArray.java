package com.datastructures.dp;

public class MaxSumArray {
    static int maxContinuousArray(int[] a){
        int[] f=new int[a.length];
        int maxSoFar=a[0]=f[0];
        for(int i=1;i<a.length;i++){
            f[i]=Math.max(a[i],f[i-1]+a[i]);
        }
        for(int i=0;i<a.length;i++){
            maxSoFar=Math.max(maxSoFar,f[i]);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        System.out.println(maxContinuousArray(new int[]{ -2, -3, 4, -1, -2, 1, 5, -3 }));
    }
}
