package com.collectionslearn;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class PQ {
    public static void main(String[] args) {
        Queue<Integer> pq=new PriorityQueue<>();
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
        System.out.println(pq.peek());
    }
}
//Queue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder())
//Comparator.reverseOrder() will implement max heap