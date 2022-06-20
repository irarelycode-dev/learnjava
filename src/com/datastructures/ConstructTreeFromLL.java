package com.datastructures;

class NodeConstruct{
    NodeConstruct left;
    NodeConstruct right;
    int key;
    public NodeConstruct(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class ConstructTreeFromLL {
    static NodeConstruct buildTree(java.util.List<Integer> ll,int index){
        if(ll.size()==index || ll.size()-1<index) return null;
        NodeConstruct root=new NodeConstruct(ll.get(index));
        root.left=buildTree(ll,2*index+1);
        root.right=buildTree(ll,2*index+2);
        return root;
    }
    static void printPreorder(NodeConstruct root){
        if(root==null) return;
        System.out.println(root.key);
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void main(String[] args) {
        java.util.List<Integer> ll=new java.util.LinkedList<>();
        ll.add(10);
        ll.add(12);
        ll.add(15);
        ll.add(25);
        ll.add(30);
        ll.add(36);
        ll.add(39);
        NodeConstruct root=buildTree(ll,0);
        printPreorder(root);
    }
}
