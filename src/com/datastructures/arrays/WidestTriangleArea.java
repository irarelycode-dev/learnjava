package com.datastructures.arrays;

import java.util.Scanner;

public class WidestTriangleArea {
    public static int findWidestBase(int[] nums){
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int incr =0, decr =0;
            while(nums[i]<nums[i+1])
            {
                incr+=1;
                i++;
            }
            int j =i;
            while(nums[j]>nums[j+1])
            {
                decr+=1;
                j++;
                if(j+1>= nums.length)
                    break;
            }
            if(maxSoFar<incr+decr+1)
            {
                maxSoFar = incr+decr+1;
            }
            i = j;
            if(i+2>=nums.length)
                break;
        }
        return maxSoFar;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String[] temp = input.split(",");
        int[] nums = new int[temp.length];
        for(int i=0;i< nums.length;i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        System.out.println(findWidestBase(nums));
    }
}
