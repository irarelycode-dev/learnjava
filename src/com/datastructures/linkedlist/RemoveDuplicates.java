package com.datastructures.linkedlist;

abstract class RemoveDuplicatesAbstract{
    abstract Node removeDuplicates(Node head);
}

public class RemoveDuplicates extends RemoveDuplicatesAbstract{
    Node removeNode(Node node){
        Node nextNode=node.next;
        node.next=null;
        return nextNode;
    }
    public Node removeDuplicates(Node head){
        if(head==null) return head;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            if(next==null) break;
            if(next.key==curr.key) {
                Node nextToRemoved=removeNode(next);
                curr.next=nextToRemoved;
            }
            curr=curr.next;
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
        RemoveDuplicates object=new RemoveDuplicates();
        Node root=new Node(11);
        root.next=new Node(11);
        root.next.next=new Node(12);
        root.next.next.next=new Node(12);
        root.next.next.next.next=new Node(13);
        root=object.removeDuplicates(root);
        object.printNodes(root);
    }
}
