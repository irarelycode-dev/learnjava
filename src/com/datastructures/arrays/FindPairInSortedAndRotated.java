package com.datastructures.arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FindPairInSortedAndRotated {
    //time complexity: O(n), space complexity: O(n)
    public List<Integer>  findPair(int[] arr,int sum){
        List<Integer> pairs=new ArrayList<>();
        Map<Integer,Boolean> hm=new HashMap<>();
        for (int j : arr) {
            if (!hm.containsKey(j)) hm.put(j, true);
            if (hm.containsKey(sum - j) && sum-j!=j) {
                pairs.add(j);
                pairs.add(sum-j);
                break;
            }
        }
        return pairs;
    }


    //time complexity: O(n), space complexity: O(1)
    int findPivot(int[] arr,int low,int high){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(low<mid && arr[mid]>arr[mid+1]) return mid;
        if(mid<high && arr[mid]<arr[mid-1]) return mid-1;
        if(arr[mid]>=arr[low]) return findPivot(arr,low,mid-1);
        return findPivot(arr,mid+1,high);
    }
    public List<Integer> findPairsTwo(int[] arr,int sum){
        List<Integer> pairs=new ArrayList<>();
        int pivot=findPivot(arr,0,arr.length-1);
        int ptr1=pivot,ptr2=pivot+1;
        while(ptr1!=ptr2){
            int currSum=arr[ptr2]+arr[ptr1];
            if(currSum==sum){
                pairs.add(arr[ptr1]);
                pairs.add(arr[ptr2]);
                break;
            }
            if(currSum>sum) {
                ptr1--;
                if(ptr1==-1) ptr1=arr.length-1;
            }
            if(currSum<sum){
                ptr2++;
                if(ptr2==arr.length) ptr2=0;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        FindPairInSortedAndRotated obj=new FindPairInSortedAndRotated();
        List<Integer> pairs=obj.findPairsTwo(new int[]{11,15,6,8,9,10},100);
        for(Integer num:pairs) System.out.print(num+" ");
    }
}
