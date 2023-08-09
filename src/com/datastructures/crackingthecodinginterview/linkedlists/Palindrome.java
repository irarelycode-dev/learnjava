package com.datastructures.crackingthecodinginterview.linkedlists;

public class Palindrome {
    static class Node {
        Character key;
        Node next;

        Node(Character _key) {
            this.key = _key;
        }
    }

    private static boolean ll_palin(Node[] left, Node right) {
        if (right == null) return true;
        boolean res = ll_palin(left, right.next);
        if (res == false) return false;
        boolean cmp = left[0].key == right.key;
        left[0] = left[0].next;
        return cmp;
    }

    private static Node constructList(Character[] keys) {
        Node head = null, tail = null;
        for (Character ch : keys) {
            if (head == null && tail == null) {
                head = tail = new Node(ch);
            } else {
                tail.next = new Node(ch);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = constructList(new Character[]{'1', '2', '3', '3', '2', '1'});
        Node[] left = new Node[1];
        left[0] = new Node('1');
        left[0].next = new Node('2');
        left[0].next.next = new Node('3');
        left[0].next.next.next = new Node('3');
        left[0].next.next.next.next = new Node('2');
        left[0].next.next.next.next.next = new Node('1');
//        left[0].next.next.next.next.next.next = new Node('1');
        System.out.println(ll_palin(left, head));
    }

}
