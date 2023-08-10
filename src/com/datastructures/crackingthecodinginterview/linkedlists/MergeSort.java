package com.datastructures.crackingthecodinginterview.linkedlists;

public class MergeSort {
    private static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
        }
    }

    private static Node buildLL(int[] keys) {
        Node head = null, tail = null;
        for (int key : keys) {
            if (head == null && tail == null) {
                head = tail = new Node(key);
            } else {
                tail.next = new Node(key);
                tail = tail.next;
            }
        }
        return head;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        return sortedMerge(left, right);
    }


    private static Node sortedMerge(Node left, Node right) {
        Node result = null;
        if (left == null) return right;
        if (right == null) return left;
        if (left.key <= right.key) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    private static Node getMiddle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] keys = {15, 10, 5, 20, 3, 2};
        Node head = buildLL(keys);
        head = mergeSort(head);
        printList(head);
    }
}
