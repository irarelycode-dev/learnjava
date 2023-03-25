package com.pod;

import java.util.Arrays;
import java.util.Scanner;

public class POD_Array_Target_Sum {
    public boolean isPair(int[] nums,int target){
        Arrays.sort(nums);
        int ptr1=0,ptr2=nums.length-1;
        while(ptr1<=ptr2){
            int sum=nums[ptr1]+nums[ptr2];
            if(sum<target) ptr1++;
            else if(sum>target) ptr2--;
            else return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] str=scan.nextLine().split(" ");
        int len=Integer.parseInt(str[0]);
        int target=Integer.parseInt(str[1]);
        int[] input=Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new POD_Array_Target_Sum().isPair(input,target));
    }
}
