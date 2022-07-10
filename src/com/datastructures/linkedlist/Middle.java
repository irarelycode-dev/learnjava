package com.datastructures.linkedlist;

abstract class FindMiddleNode{
    abstract public void findMiddleNode(Node head);
}

public class Middle extends FindMiddleNode {
    @Override
    public void findMiddleNode(Node head){
        if(head==null) return;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.key);
    }

    public static void main(String[] args) {
        Middle object=new Middle();
        GenerateList obj=new GenerateList();
        Node head=obj.generateList(120);
        object.findMiddleNode(head);
    }
}
