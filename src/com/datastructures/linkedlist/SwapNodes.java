package com.datastructures.linkedlist;

interface ISwapNodes{
    Node swapNodes(Node head,Node a,Node b);
}

public class SwapNodes implements ISwapNodes {
   public Node swapNodes(Node head,Node a,Node b){
       Node aPrev=null,aNext=null,bPrev=null,bNext=null,curr=head,prev=null;
       if(head==null || a==null || b==null || a==b) return head;
       while(curr!=null){
           if(curr==a){
               aNext=curr.next;
               aPrev=prev;
           }
           if(curr==b){
               bNext=curr.next;
               bPrev=prev;
           }
           prev=curr;
           curr=curr.next;
       }
       return head;
    }
    public void printNodes(Node head){
       if(head==null){
           System.out.println("null");
           return;
       }
        System.out.println(head.key+"->");
       printNodes(head.next);
    }
    public static void main(String[] args) {
       SwapNodes object=new SwapNodes();
       Node head=new Node(1);
       head.next=new Node(3);
       head.next.next=new Node(4);
       head.next.next.next=new Node(5);
       head=object.swapNodes(head,head,head.next.next.next);
       object.printNodes(head);
    }
}

// 11->12->13->14->15