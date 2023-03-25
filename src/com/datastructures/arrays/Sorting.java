package com.datastructures.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
    public class ArraySorting {

        public static List<Integer> insert(List<Integer> arr,int temp){
            if(arr.size()==0 ){
                arr.add(temp);
                return arr;
            }else if((int)arr.get(0)>=temp){
                arr.add(0,temp);
                return arr;
            }else if((int)arr.get(arr.size()-1)<=temp){
                arr.add(arr.size(),temp);
                return arr;
            }
            int temp1 =(int) arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr = insert(arr,temp);
            arr.add(arr.size(),temp1);
            return arr;
        }

        public static List<Integer> sort(List<Integer> nums) {
            if (nums.size() == 1) {
                return nums;
            }
            int temp = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);
            nums = sort(nums);
            nums = insert(nums, temp);
            return nums;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int[] arr = new int[5];
            System.out.println("Enter elements of the array (size 5) : ");
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            List<Integer> al = new ArrayList<>();
            List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
            System.out.println("nums:"+nums);
            al = sort(nums);
            System.out.println(al);
            sc.close();
        }
    }
}
