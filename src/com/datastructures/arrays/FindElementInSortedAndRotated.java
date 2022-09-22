package com.datastructures.arrays;

interface ElementInSortedAndRotatedArray{
    int findElement(int[] arr,int key);
}

public class FindElementInSortedAndRotated implements ElementInSortedAndRotatedArray {
    public int findPivot(int[] arr,int low,int high){
        if(low>high) return -1;
        if(low==high) return low;
        int mid=low+(high-low)/2;
        if(mid>low && arr[mid]>arr[mid+1]) return mid;
        if(mid<high && arr[mid]<arr[mid-1]) return mid-1;
        if(arr[low]>=arr[mid]) return findPivot(arr,low,mid-1);
        return findPivot(arr,mid+1,high);
    }
    public int findElementPosition(int[] arr,int low,int high,int key){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==key) return mid;
        if(arr[mid]>key) return findElementPosition(arr,low,mid-1,key);
        return findElementPosition(arr,mid+1,high,key);
    }
    public int findElement(int[] arr,int key){
        int pivot=findPivot(arr,0,arr.length-1);
        int low=0,high=arr.length-1;
        if(pivot!=-1){
            if(arr[pivot+1]>=key && arr[low]<=key){
                high=pivot;
            }
            if(arr[pivot+1]<key && arr[high]>=key){
                low=pivot+1;
            }
        }
        return findElementPosition(arr,low,high,key);
    }

    public static void main(String[] args) {
        FindElementInSortedAndRotated obj=new FindElementInSortedAndRotated();
        int position=obj.findElement(new int[]{ 5, 6, 7, 8, 9, 10, 1, 2, 3 },3);
        System.out.println(position);
    }
}
