package com.collectionslearn;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class PQ {

    static class Item{
        public int value;
        public int priority;
    }

    static Item[] pq=new Item[100000];
    static int size=-1;

    static void enque(int value,int priority){
        size++;
        Item item=new Item();
        pq[size]=item;
        item.value=value;
        item.priority=priority;
    }

    static int peek(){
        int priority=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<=size;i++){
            if(priority==pq[i].priority && index>-1&&pq[index].value<pq[i].value){
                priority=pq[i].priority;
                index=i;
            }else if(priority<pq[i].priority){
                priority=pq[i].priority;
                index=i;
            }
        }
        return index;
    }

    static Item deque(){
        int idx=peek();
        Item tmp=pq[idx];
        for(int i=idx;i<size;i++){
            pq[i]=pq[i+1];
        }
        size--;
        return tmp;
    }


    public static void main(String[] args) {
        enque(10,2);
        enque(14,4);
        enque(16,4);
        enque(12,3);
        int idx=peek();
        System.out.println("Element with highest priority:"+pq[idx].value);
        deque();
        idx=peek();
        System.out.println("Element with highest priority:"+pq[idx].value);
        deque();
        idx=peek();
        System.out.println("Element with highest priority:"+pq[idx].value);
    }
}