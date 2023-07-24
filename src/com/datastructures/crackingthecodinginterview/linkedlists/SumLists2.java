package com.datastructures.crackingthecodinginterview.linkedlists;

public class SumLists2 {
    static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    private static Node createList(int[] nums) {
        Node head = null, tail = null;
        for (int num : nums) {
            if (head == null) {
                head = new Node(num);
                tail = head;
            } else {
                tail.next = new Node(num);
                tail = tail.next;
            }
        }
        return head;
    }

    private static Node createNode(Node tail, int key) {
        if (tail == null) {
            return new Node(key);
        }
        tail.next = new Node(key);
        tail = tail.next;
        return tail;
    }

    static Node createSum(Node list1, Node list2) {
        int carry = 0;
        Node head = null, tail = null;
        while (list1 != null && list2 != null) {
            int val = list1 != null && list2 != null ? (list1.key + list2.key + carry) : list1 == null ? (list2.key + carry) : (list1.key + carry);
            if (head == null && tail == null) {
                head = tail = createNode(head, val % 10);
                carry = val / 10;
            } else {
                tail = createNode(tail, val % 10);
                carry = val / 10;
            }
            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }
        if (carry > 0) {
            tail = createNode(tail, carry);
        }
        return head;
    }

    static void printList(Node list) {
        for (Node curr = list; curr != null; curr = curr.next) {
            System.out.print(curr.key + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 1, 8};
        int[] nums2 = {5, 9, 2};
        Node list1 = createList(nums1);
        Node list2 = createList(nums2);
        Node head = createSum(list1, list2);
        printList(head);
    }
}
