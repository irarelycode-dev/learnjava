package com.datastructures.linkedlist;

abstract class LoopRemove{
    abstract protected Node removeLoop(Node root);
}
public class RemoveLoop extends LoopRemove {
    @Override
    public Node removeLoop(Node root){
        if(root==null) return root;
        return root;
    }
}
