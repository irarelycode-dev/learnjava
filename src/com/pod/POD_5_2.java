package com.pod;

import java.util.Scanner;

public class POD_5_2 {
    public static int findJumps(int[] nums){
        if (nums.length == 0 || nums[0] == 0)
            return 0;
        if (nums.length == 1)
            return 0;
        int minJumps = 0;
        int end = 0;
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                end = far;
                minJumps++;
                if (end >= nums.length - 1)
                    break;
            }
        }
        return minJumps;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        String[] str=scan.nextLine().split(" ");
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findJumps(nums));
    }
}
