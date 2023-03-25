package com.datastructures.dp;

public class MaximumSubArray {
    public static  int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution arrayyy
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            System.out.println("j:"+j);
            if(result<solution[j])
                result = solution[j];
            System.out.println("result:"+result);
        }

        return result;
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here
                = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{13,-25,18,20,-7,12,-5,4}));
        System.out.println(solve(new int[]{13,-25,18,20,-7,12,-5,4}));
    }

}
