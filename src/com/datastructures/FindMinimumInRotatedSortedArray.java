package com.datastructures;

public class FindMinimumInRotatedSortedArray {
    int findMinimumElement(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]) left=mid+1;
            else right=mid;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray object=new FindMinimumInRotatedSortedArray();
        int[] nums={11,13,15,17};
        System.out.println(object.findMinimumElement(nums));
    }
}
