package com.datastructures.arrays;

public class AssignmentOnePartAOne {
    public void replaceElements(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target && i+1!=nums.length){
                int tmp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=tmp;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        AssignmentOnePartAOne obj=new AssignmentOnePartAOne();
        int[] nums={5, 4, 6, 9, 6, 3, 6};
        obj.replaceElements(nums,6);
        for(int a:nums) System.out.print(a+" ");
    }
}

//time complexity: O(n)
//space complexity: O(1)