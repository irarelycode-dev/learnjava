package com.datastructures.divideandconquer;

public class MinInArrDnC {
    static int min(int[] arr,int l,int r){
        if(l==r) return arr[l];
        int mid=l+(r-l)/2;
        int a=min(arr,l,mid);
        int b=min(arr,mid+1,r);
        return a<b?a:b;
    }
    public static void main(String[] args) {
        int[] arr={3,4,2,1,7,5,6,89,0};
        System.out.println(min(arr,0,arr.length-1));
    }
}
