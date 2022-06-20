package com.datastructures;

class BTNode{
    BTNode left;
    BTNode right;
    int key;
    public BTNode(int key){
        this.key=key;
        this.left=this.right=null;
    }
}
//incomplete
public class TreePath {
    static java.util.Set<Integer> hashSet=new java.util.HashSet<>();
    static BTNode tracePath(BTNode root,BTNode target){
        if(root==null || root==target) return root;
        BTNode left=tracePath(root.left,target);
        BTNode right=tracePath(root.right,target);
        return root;
    }
    public static void main(String[] args) {
        BTNode root=new BTNode(10);
        root.left=new BTNode(20);
        root.right=new BTNode(30);
        root.left.left=new BTNode(40);
        tracePath(root,root.left);
        System.out.println(hashSet);
    }
}
