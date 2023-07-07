package com.datastructures.crackingthecodinginterview.linkedlists;

public class KthToLast {
    static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    static int count = 0;
    static int target;

    private static void kthToLast(Node head, int k) {
        if (head == null) return;
        kthToLast(head.next, k);
        count++;
        if (count == k) target = head.key;
    }

    //tc: O(N) if k is 1, < O(N/2) if k < n/2
    //sc: O(1)
    private static int kthToLast2(Node head, int k) {
        Node first = head;
        Node second;
        int ct = 0;
        for (Node curr = head; ; curr = curr.next) {
            ct++;
            if (ct == k) {
                second = curr;
                break;
            }
        }
        for (Node curr = second; curr.next != null; curr = curr.next) {
            first = first.next;
            second = second.next;
        }
        return first.key;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        kthToLast(head, 4);
        System.out.println("target:" + target);
        System.out.println(kthToLast2(head, 6));
    }

}