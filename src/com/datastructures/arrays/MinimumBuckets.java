package com.datastructures.arrays;

import java.util.*;

public class MinimumBuckets {
    public static int minimumBuckets(long N,long target){
        int count=0;
        long sum=0;
        for(long i=N;i>=1;i--){
            sum+=i;
            count++;
            if(sum>target){
                count--;
                sum-=i;
            }
            if(sum==target){
                break;
            }
        }
        return target==sum?count:-1;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] inputs=scan.nextLine().split(" ");
        System.out.println(minimumBuckets(Long.parseLong(inputs[0]),Long.parseLong(inputs[1])));
    }
}
