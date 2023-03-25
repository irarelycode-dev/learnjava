package com.pod;

import java.util.Arrays;
import java.util.Queue;

public class POD_Queue_Sum {
    public int equalSum(Queue<Integer> queue1,Queue<Integer> queue2){
        int count=0;
        int maxSize=queue1.size()>queue2.size()?queue1.size():queue2.size();
        boolean flag=false;
        while(true){
            int sum1=queue1.stream().reduce(0,(a,b)->a+b);
            int sum2=queue2.stream().reduce(0,(a,b)->a+b);
            if(sum1==sum2) break;
            if(count>maxSize){
                flag=true;
                break;
            }
            else if(sum1>sum2){
                int tmp=queue1.poll();
                queue2.add(tmp);
                count++;
            }else{
                int tmp=queue2.poll();
                queue1.add(tmp);
                count++;
            }
        }
        return flag?-1:count;
    }
    public static void main(String[] args) {

    }
}
