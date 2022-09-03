package com.datastructures.arrays;

import java.util.Iterator;
import java.util.LinkedList;

public class MaximumInSubArrays {
    static LinkedList<Integer> ll=new LinkedList<>();

    // O(n*k)
    static void maximumInSubArrays(int[] sub,int k){
        int start=0,end=0,count=0,max=Integer.MIN_VALUE;
        while(end!=sub.length){
            if(sub[end]>=max) max=sub[end];
            count++;
            end++;
            if(count==k){
                count=0;
                start++;
                end=start;
                ll.add(max);
                max=Integer.MIN_VALUE;
            }
        }
    }
    static void printList(){
        Iterator itr=ll.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,1,4,5,2,3,6,7,11,12};
        maximumInSubArrays(arr,3);
        printList();
    }
}
