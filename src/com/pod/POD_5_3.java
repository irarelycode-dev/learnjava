package com.pod;

import java.util.*;

public class POD_5_3 {
    public static int maximumDifference(int[] nums){
        int diff=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                diff=Math.max(diff,nums[j]-nums[i]);
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        String[] res=scan.nextLine().split(",");
        int[] nums=new int[res.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(res[i]);
        }
        System.out.println(maximumDifference(nums));
    }
}
