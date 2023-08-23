package com.datastructures.linkedlist;

import java.math.BigInteger;
import java.util.Stack;

public class AddNumbers {
    private static class ListNode {
        int key;
        ListNode next;

        ListNode() {
        }

        ListNode(int _key) {
            this.key = _key;
            this.next = null;
        }
    }

    private static ListNode addNumbers(ListNode head1, ListNode head2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (ListNode head = head1; head != null; head = head.next) {
            num1.append(head.key);
        }
        for (ListNode head = head2; head != null; head = head.next) {
            num2.append(head.key);
        }
        String result = (new BigInteger(num1.toString())).add(new BigInteger(num2.toString())).toString();
        ListNode head = null, tail = null;
        for (int i = 0; i < result.length(); ++i) {
            if (head == null) {
                head = tail = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))));
            } else {
                tail.next = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))));
                tail = tail.next;
            }
        }
        return head;
    }

    private static ListNode addNums(ListNode head1, ListNode head2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for (ListNode head = head1; head != null; head = head.next) {
            st1.push(head.key);
        }
        for (ListNode head = head2; head != null; head = head.next) {
            st2.push(head.key);
        }
        int carry = 0;
        ListNode head = null, tail = null;
        while (st1.size() > 0 || st2.size() > 0 || carry != 0) {
            int sum = st1.size() > 0 && st2.size() > 0 ? st1.pop() + st2.pop() + carry : st1.size() > 0 && st2.size() == 0 ? st1.pop() + carry : st1.size() == 0 && st2.size() > 0 ? st2.pop() + carry : carry;
            int val = sum % 10;
            carry = val / 10;
            if (head == null) {
                head = tail = new ListNode(val);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
