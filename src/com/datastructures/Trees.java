package com.datastructures;

class TreeNode{
    int elem;
    TreeNode left;
    TreeNode right;
    public TreeNode(int elem){
        this.left=this.right=null;
        this.elem=elem;
    }
}

public class Trees {
    void printPostOrder(TreeNode node){
        if(node==null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.elem+" ");
    }
    void printPreOrder(TreeNode node){
        if(node==null) return;
        System.out.print(node.elem+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    void printInorder(TreeNode node){
        if(node==null) return;
        printInorder(node.left);
        System.out.print(node.elem+" ");
        printInorder(node.right);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(20);
        root.left.left=new TreeNode(21);
        root.left.right=new TreeNode(32);
        new Trees().printInorder(root);
    }
}
