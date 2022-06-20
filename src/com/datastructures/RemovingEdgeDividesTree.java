package com.datastructures;

class TreeNodeNode{
    int key;
    TreeNodeNode left;
    TreeNodeNode right;
    public TreeNodeNode(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class RemovingEdgeDividesTree {

    static int count(TreeNodeNode node){
        if(node==null) return 0;
        return count(node.left)+count(node.right)+1;
    }

    static boolean countNodesAndCheck(TreeNodeNode root,int n){
        if(root==null) return false;
        if(n-count(root)==count(root)) return true;
        return countNodesAndCheck(root.left,n) || countNodesAndCheck(root.right,n);
    }

    static boolean possible=false;
    static int checkIfPossible(TreeNodeNode root,int n){
        if(root==null) return 0;
        int c=checkIfPossible(root.left,n)+1+checkIfPossible(root.right,n);
        if(n-c==c){
            possible=true;
        }
        return c;
    }

    static boolean removeEdgeDividesTree(TreeNodeNode root){
        int nodes=count(root);
        return countNodesAndCheck(root,nodes);
    }

    public static void main(String[] args) {

    }
}
