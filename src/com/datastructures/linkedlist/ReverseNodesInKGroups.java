package com.datastructures.linkedlist;

public class ReverseNodesInKGroups {
    public Node reverseNodesInKGroups(Node head,int k){
        Node dummy=new Node(-1);
        dummy.next=head;
        Node pointer=dummy;
        while(pointer!=null){
            Node curr=pointer;
            for(int i=0;i<k && curr!=null;i++) curr=curr.next;
            if(curr==null) break;
            Node prev=null,node=pointer.next;
            for(int i=0;i<k;i++){
                Node next=node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            pointer=curr;
        }
        return dummy.next;
    }
}
