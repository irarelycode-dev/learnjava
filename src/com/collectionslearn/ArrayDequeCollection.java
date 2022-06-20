package com.collectionslearn;

import java.util.ArrayDeque;
import java.util.Queue;
import accessmodifiers.ProtectedModifiers;


public class ArrayDequeCollection extends ProtectedModifiers {
    public static void main(String[] args) {
        ArrayDequeCollection object=new ArrayDequeCollection();
        object.msg();
        ArrayDeque<Integer> adq=new ArrayDeque<>();
        adq.offer(23);
        System.out.println(adq);
        adq.offerFirst(12);
        System.out.println(adq);
        adq.offerLast(45);
        System.out.println(adq);
        System.out.println(adq.peek());
        System.out.println(adq.peekLast());
        adq.poll();
        System.out.println(adq);
    }
}
//poll()
//pollFirst()
//pollLast()
