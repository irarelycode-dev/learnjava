package com.datastructures.crackingthecodinginterview.stacks;

import java.util.EmptyStackException;

public class PushPopMin {
    static class Node {
        int key;
        int min;
        int max;
        Node next;

        Node(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    private Node head;

    PushPopMin() {
        head = null;
    }

    private void push(int value) {
        if (this.head == null) {
            head = new Node(value);
            head.min = head.max = value;
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
            if (value < node.next.min) head.min = value;
            else head.min = node.next.min;
            if (value > node.next.max) head.max = value;
            else head.max = node.next.max;
        }
    }

    private int pop() {
        if (head == null) throw new EmptyStackException();
        int tmp = head.key;
        head = head.next;
        return tmp;
    }

    private int getMin() {
        return head.min;
    }

    private int getMax() {
        return head.max;
    }

    public static void main(String[] args) {
        PushPopMin o = new PushPopMin();
        o.push(10);
        o.push(2);
        o.push(6);
        o.push(11);
        o.push(1);
        System.out.println("min:" + o.getMin());
        System.out.println("max:" + o.getMax());
        o.pop();
        System.out.println("min:" + o.getMin());
        System.out.println("max:" + o.getMax());
        o.pop();
        System.out.println("min:" + o.getMin());
        System.out.println("max:" + o.getMax());
    }
}
