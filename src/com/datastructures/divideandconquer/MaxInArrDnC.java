package com.datastructures.divideandconquer;

public class MaxInArrDnC {
    static int max(int[] arr,int l,int r){
        if(l==r) return arr[l];
        int mid=l+(r-l)/2;
        int a=max(arr,l,mid);
        int b=max(arr,mid+1,r);
        return a>b?a:b;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,0,8};
        System.out.println(max(arr,0,arr.length-1));
    }
}

