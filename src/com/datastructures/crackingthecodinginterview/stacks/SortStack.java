package com.datastructures.crackingthecodinginterview.stacks;

import java.util.EmptyStackException;

public class SortStack {
    private static class Node {
        int key;
        Node next;

        Node(int _key) {
            this.key = _key;
        }
    }

    private static class NodeKey {
        Node node;
        int key;

        NodeKey(Node _node, int _key) {
            this.node = _node;
            this.key = _key;
        }
    }

    private static Node push(Node head, int key) {
        if (head == null) {
            head = new Node(key);
            return head;
        }
        Node tmp = new Node(key);
        tmp.next = head;
        head = tmp;
        return head;
    }

    private static NodeKey pop(Node head) {
        int key = peek(head);
        head = head.next;
        return new NodeKey(head, key);
    }

    private static int peek(Node head) {
        if (head == null) throw new EmptyStackException();
        return head.key;
    }

    public static Node sortStack(Node head) {
        if (head == null) return head;
        Node buffer = null;
        while (head != null) {
            NodeKey n = pop(head);
            head = n.node;
            int key = n.key;
            if (buffer == null) {
                buffer = new Node(key);
                continue;
            }
            if (peek(buffer) <= key) {
                Node tmp = new Node(key);
                tmp.next = buffer;
                buffer = tmp;
                continue;
            }
            Node tmp = buffer, prev = null;
            while (tmp != null && peek(tmp) > key) {
                prev = tmp;
                tmp = tmp.next;
            }
            prev.next = new Node(key);
            prev.next.next = tmp;
        }
        while (buffer != null) {
            NodeKey n = pop(buffer);
            buffer = n.node;
            head = push(head, n.key);
        }
        return head;
    }

    private static void printStack(Node head) {
        while (head != null) {
            System.out.println("key:" + head.key);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = push(null, 12);
        head = push(head, 1);
        head = push(head, 3);
        head = push(head, 6);
        head = push(head, 14);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 2);
        head = push(head, 0);
        System.out.println("Before sort:");
        printStack(head);
        head = sortStack(head);
        System.out.println("After sort:");
        printStack(head);
    }

}
