package com.datastructures.linkedlist;

public class GenerateList {
    Node root;
    Node curr;
    public Node generateList(int number){
        int i=1;
        root=new Node(i);
        curr=root;
        while(i<=number){
            i++;
            curr.next=new Node(i);
            curr=curr.next;
        }
        return root;
    }
}
