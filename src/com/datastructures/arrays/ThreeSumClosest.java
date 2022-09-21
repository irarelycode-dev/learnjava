package com.datastructures.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] arr,int target){
        Arrays.sort(arr);
        int closestSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-2;i++){
            int ptr1=i+1,ptr2=arr.length-1,sum=arr[i];
            while(ptr1<ptr2){
                sum+=arr[ptr1]+arr[ptr2];
                if(sum>target){
                    ptr2--;
                }else if(sum<target){
                    ptr1--;
                }else{
                    return sum;
                }
                if(Math.abs((long)closestSum-target)>Math.abs(sum-target)){
                    closestSum=sum;
                }
                sum=arr[i];
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {

    }
}
