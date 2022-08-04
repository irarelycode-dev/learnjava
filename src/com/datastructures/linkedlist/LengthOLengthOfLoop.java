package com.datastructures.linkedlist;


interface CountLoopLength{
    public int countLoop(Node head);
}


abstract class FindLoopLength{
    abstract public int findLength(Node head);
}

public class LengthOLengthOfLoop extends FindLoopLength implements CountLoopLength {
    @Override
    public int findLength(Node head){
        if(head==null) return 0;
        Node slow_ptr=head;
        Node fast_ptr=head;
        while(fast_ptr!=null && fast_ptr.next!=null){
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            if(slow_ptr==fast_ptr){
                return countLoop(slow_ptr);
            }
        }
        return 0;
    }

    public int countLoop(Node head){
        Node tmp=head;
        Node curr=head.next;
        int count=1;
        while(curr!=tmp){
            curr=curr.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=head.next.next;
        LengthOLengthOfLoop obj=new LengthOLengthOfLoop();
        System.out.println(obj.findLength(head));
    }
}
