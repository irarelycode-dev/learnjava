package com.datastructures.linkedlist;

public class ReverseLinkedList {
    public Node reverseList(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return head;
    }
}
