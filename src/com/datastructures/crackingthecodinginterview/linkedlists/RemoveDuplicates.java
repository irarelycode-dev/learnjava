package com.datastructures.crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    private static Node removeDuplicate(Node head) {
        if (head == null) return head;
        Set<Integer> hashSet = new HashSet<>();
        Node curr = head, prev = head;
        while (curr != null) {
            if (hashSet.contains(curr.key)) {
                curr = curr.next;
                prev.next = curr;
            } else {
                hashSet.add(curr.key);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    static void printNodes(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);
        head = removeDuplicate(head);
        printNodes(head);
    }
}
