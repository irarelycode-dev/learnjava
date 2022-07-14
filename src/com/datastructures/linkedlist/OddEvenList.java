package com.datastructures.linkedlist;

public class OddEvenList {
    public Node oddEvenSeparate(Node head){
        if(head==null) return head;
        Node odd=head,even=head.next,firstEven=head.next;
        while(even!=null && even.next!=null){
            Node nextOdd=odd.next.next;
            Node nextEven=even.next.next;
            odd.next=nextOdd;
            odd=nextOdd;
            even.next=nextEven;
            even=nextEven;
        }
        odd.next=firstEven;
        return head;
    }
    public void printList(Node head){
        if(head==null) return;
        System.out.println(head.key);
        printList(head.next);
    }

    public static void main(String[] args) {
        GenerateList list=new GenerateList();
        OddEvenList oe=new OddEvenList();
        Node head=list.generateList(6);
        head=oe.oddEvenSeparate(head);
        oe.printList(head);
    }
}
