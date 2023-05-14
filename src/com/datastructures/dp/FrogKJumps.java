package com.datastructures.dp;

import java.util.Arrays;

public class FrogKJumps {

    //T.C: O(n*k) for every junction, we are making k recursive calls
    //Space:O(n)+O(n)- stack space and memoization
    private static int frogKJumps(int[] energies,int index,int[] dp,int k){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;++i){
            if(index-i>=0){
                int tmp=frogKJumps(energies,index-i,dp,k)+Math.abs(energies[index]-energies[i]);
                min=Math.min(tmp,min);
            }
        }
        return dp[index]=min;
    }

    private static int frogKJumpsBottomupApproach(int[] energies,int k){
        int[] dp=new int[energies.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<energies.length;++i){
            int tmp=Integer.MAX_VALUE;
            for(int j=1;j<=k;++j){
                tmp=Math.min(tmp,Math.abs(energies[i]-energies[j]));
            }
            dp[i]=tmp;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] energies={30,10,60,10,60,50};
        int[] dp=new int[energies.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        System.out.println(frogKJumps(energies,energies.length-1,dp,2));
        System.out.println(frogKJumpsBottomupApproach(energies,2));
    }
}
