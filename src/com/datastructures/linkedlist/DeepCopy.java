package com.datastructures.linkedlist;

public class DeepCopy {

    private static class Node {
        int val;
        Node next;
        Node random;

        Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }
    }

    private static Node deepClone(Node head) {
        for (Node t = head; t != null; ) {
            Node next = t.next;
            Node copy = new Node(t.val);
            t.next = copy;
            copy.next = next;
            t = next;
        }

        for (Node t = head; t != null; ) {
            if (t.random != null) {
                t.next.random = t.random.next;
            }
            t = t.next.next;
        }
        Node dummy = new Node(-1);
        Node copy = dummy;
        for (Node t = head; t != null; ) {
            Node next = t.next.next;
            copy.next = t.next;
            t.next = next;
            copy = copy.next;
            t = t.next;
        }
        return dummy.next;
    }

    private static void printList(Node head) {
        for (Node t = head; t != null; t = t.next) System.out.print(t.val + " ");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(11);
        head.next.next = new Node(12);
        head.next.next.next = new Node(13);
        printList(head);
        System.out.println();
        head = deepClone(head);
        printList(head);
    }
}
