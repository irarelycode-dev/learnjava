package com.datastructures.crackingthecodinginterview.linkedlists;

public class LoopDetection {
    private static class Node {
        char key;
        Node next;

        Node(char _key) {
            this.key = _key;
        }

        @Override
        public String toString() {
            return "key: " + this.key;
        }
    }

    private static Node doesLoopExist(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast && slow != head) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('d');
        head.next.next.next.next = head.next.next;
        System.out.println(doesLoopExist(head));
    }
}
