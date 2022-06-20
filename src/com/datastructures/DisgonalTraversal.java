package com.datastructures;

class BTreeNode{
    int key;
    BTreeNode left;
    BTreeNode right;
    public BTreeNode(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class DisgonalTraversal {
    static void printDiagonal(BTreeNode node){
        java.util.Stack<BTreeNode> stackOne=new java.util.Stack<>();
        java.util.Stack<BTreeNode> stackTwo=new java.util.Stack<>();
        stackOne.push(node);
        while(stackOne.size()!=0){
            BTreeNode curr=stackOne.pop();
            System.out.print(curr.key+" ");
            if(curr.right!=null) stackOne.push(curr.right);
            if(curr.left!=null) stackTwo.push(curr.left);
            if(stackOne.size()==0){
                while(stackTwo.size()!=0){
                    stackOne.push(stackTwo.pop());
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        BTreeNode root=new BTreeNode(8);
        root.left=new BTreeNode(3);
        root.left.left=new BTreeNode(1);
        root.right=new BTreeNode(10);
        root.right.left=new BTreeNode(6);
        root.right.left.left=new BTreeNode(4);
        root.right.left.right=new BTreeNode(7);
        root.right.right=new BTreeNode(14);
        root.right.right.left=new BTreeNode(13);
        printDiagonal(root);
    }
}
