package com.collectionslearn;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class LinkedListCollectionQueue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Queue<String> animals=new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(34);
        out.println(queue);
        queue.poll();
        out.println(queue);
        out.println(queue.peek());
        queue.remove(34);
        out.println(queue.equals(animals));
        out.println(queue);
    }
}


// remove throws an exception if queue is empty
