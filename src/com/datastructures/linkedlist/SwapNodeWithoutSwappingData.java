package com.datastructures.linkedlist;

interface SwapNodesInterface{
    Node swapNodes(Node head,Node a,Node b);
}

public class SwapNodeWithoutSwappingData implements SwapNodesInterface {
    public Node swapNodes(Node head,Node a,Node b){
        if(head==null || a==null || b==null || a==b) return head;
        Node curr=head,prev=null,aPrev=null,aNext=null,bPrev=null,bNext=null;
        while(curr!=null){
            if(curr==a){
                aPrev=prev;
                aNext=curr.next;
            }
            if(curr==b){
                bPrev=prev;
                bNext=curr.next;
            }
            prev=curr;
            curr=curr.next;
        }
        if(aPrev!=null) aPrev.next=b;
        else head=b;
        b.next=aNext;
        if(bPrev!=null) bPrev.next=a;
        a.next=bNext;
        return head;
    }

    public static void main(String[] args) {

    }
}
