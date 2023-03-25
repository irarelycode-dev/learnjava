package com.datastructures.arrays;

import java.util.Scanner;

public class SteepestPeak {
    public int steepestPeak(int[] nums){
        int steepest=0;
        int index=-1;
        for(int i=1;i<nums.length-1;i++){
            int peak=Math.max(nums[i-1]-nums[i],nums[i]-nums[i+1]);
            if(steepest<peak){
                index=i;
                steepest=peak;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        SteepestPeak obj=new SteepestPeak();
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        scan.nextLine();
        String[] str=scan.nextLine().split(",");
        int[] nums=new int[size];
        for(int i=0;i<size;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        System.out.println(obj.steepestPeak(nums));
    }
}
