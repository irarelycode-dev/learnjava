package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    static void permutate(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            permutate(left + right, ans + ch);
        }
    }

    private static String getList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(num + " ");
        }
        return sb.toString();
    }

    static void permutateList(int[] nums, List<Integer> tmp) {
        if (nums.length == 0) {
            System.out.println(getList(tmp));
        }
        for (int i = 0; i < nums.length; ++i) {
            tmp.add(nums[i]);
            int[] subArray1 = Arrays.copyOfRange(nums, 0, i);
            int[] subArray2 = Arrays.copyOfRange(nums, i + 1, nums.length);
            int[] both = Arrays.copyOf(subArray1, subArray1.length + subArray2.length);
            System.arraycopy(subArray2, 0, both, subArray1.length, subArray2.length);
            permutateList(both, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        permutate("ans", "");
        int[] nums = {1, 2, 3};
        permutateList(nums, new ArrayList<>());
    }
}
