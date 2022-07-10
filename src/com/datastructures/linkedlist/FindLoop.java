package com.datastructures.linkedlist;

abstract class AbstractFindLoop{
    abstract boolean findLoop(Node head);
}

public class FindLoop extends AbstractFindLoop {
    @Override
    public boolean findLoop(Node head){
        if(head==null) return false;
        Node slow=head;
        Node fast=head;
        boolean loopExists=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                loopExists=true;
                break;
            }
        }
        return loopExists;
    }
}
