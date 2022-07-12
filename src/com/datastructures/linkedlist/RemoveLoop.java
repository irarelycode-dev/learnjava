package com.datastructures.linkedlist;

import java.security.InvalidAlgorithmParameterException;

abstract class LoopRemove{
    abstract protected Node removeLoop(Node root) throws InvalidAlgorithmParameterException;
}

public class RemoveLoop extends LoopRemove {
    @Override
    protected Node removeLoop(Node root) throws InvalidAlgorithmParameterException {
        if(root==null) return root;
        Node slow_ptr=root;
        Node fast_ptr=root;
        boolean loop_exists=false;
        while(fast_ptr!=null && fast_ptr.next!=null){
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            if(slow_ptr==fast_ptr){
                loop_exists=true;
                break;
            }
        }
        if(!loop_exists) throw new InvalidAlgorithmParameterException("List has no loop");
        return root;
    }
    public void printNode(Node root){
        if(root==null) return;
        System.out.println(root.key);
        printNode(root.next);
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException {
        RemoveLoop o=new RemoveLoop();
        Node root=new Node(1);
        root.next=new Node(2);
        root.next.next=new Node(3);
        root.next.next.next=root.next;
        root=o.removeLoop(root);
        o.printNode(root);
    }
}
