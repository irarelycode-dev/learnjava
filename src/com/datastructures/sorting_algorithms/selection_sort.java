package com.datastructures.sorting_algorithms;

public class selection_sort {
    public void swap(int[] arr,int idx1,int idx2){
        int tmp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=tmp;
    }
    public void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min_idx=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }
            swap(arr,i,min_idx);
        }
    }

    public static void main(String[] args) {
        int[] arr={64,25,12,22,11,19};
        selection_sort obj=new selection_sort();
        obj.selectionSort(arr);
        for(int el:arr){
            System.out.println(el);
        }
    }
}
