package com.datastructures.linkedlist;

import java.util.HashMap;

abstract class RemoveDuplicatesFromUnsortedListAbstract{
    abstract Node removeDuplicates(Node head);
}

public class RemoveDuplicatesFromUnsortedList extends RemoveDuplicatesFromUnsortedListAbstract {
    public Node removeNode(Node node){
        Node nextNode=node.next;
        node.next=null;
        return nextNode;
    }
    public Node removeDuplicates(Node head){
        HashMap<Integer,Boolean> hm=new HashMap<>();
        if(head==null) return head;
        Node curr=head,prev=null;
        while(curr!=null){
            if(hm.containsKey(curr.key)){
                Node nextToDeleted=removeNode(curr);
                prev.next=nextToDeleted;
                curr=nextToDeleted;
            }else{
                hm.put(curr.key,true);
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
    public void printNodes(Node head){
        if(head==null){
            System.out.println("null");
            return;
        }
        System.out.print(head.key+"->");
        printNodes(head.next);
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromUnsortedList object=new RemoveDuplicatesFromUnsortedList();
        Node root=new Node(11);
        root.next=new Node(11);
        root.next.next=new Node(12);
        root.next.next.next=new Node(12);
        root.next.next.next.next=new Node(13);
        root.next.next.next.next.next=new Node(13);
        root.next.next.next.next.next.next=new Node(13);
        root.next.next.next.next.next.next.next=new Node(13);
        root=object.removeDuplicates(root);
        object.printNodes(root);
    }
}
