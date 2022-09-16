package com.datastructures.arrays;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

interface IThreeSum{
    public List<List<Integer>> threeSum(int[] sum);
}

public class ThreeSum implements IThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int left_pointer=i+1,right_pointer=nums.length-1,sum=nums[i];
            while(left_pointer<=right_pointer){
                sum+=nums[left_pointer]+nums[right_pointer];
                if(sum==0){
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left_pointer]);
                    triplet.add(nums[right_pointer]);
                    result.add(triplet);
                }else if(sum>0){
                    right_pointer--;
                }else{
                    left_pointer++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum object=new ThreeSum();
        List<List<Integer>> result=object.threeSum(new int[]{-1,-1,0,1,2});
        for(List<Integer> list:result){
            for(Integer a:list){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
