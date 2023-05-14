package com.datastructures.dp;

import java.util.Arrays;

public class FrogJump {
    private static int frogJump(int[] energy,int index,int[] dp){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int left=frogJump(energy,index-1,dp)+Math.abs(energy[index]-energy[index-1]);
        int right=Integer.MAX_VALUE;
        if(index>1){
            right=frogJump(energy,index-2,dp)+Math.abs(energy[index]-energy[index-2]);
        }
        return dp[index]=Math.min(left,right);
    }

    private static int frogJumpTabulation(int[] energy,int[] dp){
        dp[0]=0;
        for(int i=1;i<=dp.length-1;++i){
            int firstStep=dp[i-1]+Math.abs(energy[i]-energy[i-1]);
            int secondStep=Integer.MAX_VALUE;
            if(i>1){
                secondStep=dp[i-2]+Math.abs(energy[i]-energy[i-2]);
            }
            dp[i]=Math.min(firstStep,secondStep);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] energies={30,10,60,10,60,50};
        int[] dp=new int[energies.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
//        System.out.println(frogJump(energies,energies.length-1,dp));
//        System.out.println(frogJumpTabulation(energies,dp));
    }
}
