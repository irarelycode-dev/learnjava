package com.datastructures.crackingthecodinginterview.linkedlists;

public class DeleteMiddleNode {

    private static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    static void printNodes(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

    private static void deleteMiddleNode(Node middle) {
        if (middle == null || middle.next == null) return;
        middle.key = middle.next.key;
        middle.next = middle.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        printNodes(head);
        System.out.println();
        deleteMiddleNode(head.next.next);
        printNodes(head);
    }


}
