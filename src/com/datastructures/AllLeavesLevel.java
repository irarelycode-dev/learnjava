package com.datastructures;

class NodeTree{
    int key;
    NodeTree left;
    NodeTree right;
    public NodeTree(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }
}

public class AllLeavesLevel {
    static int rootLevel;
    static boolean checkLeaves(NodeTree root,int level){
        if(root==null) return true;
        if(root.left==null && root.right==null){
            if(rootLevel==0) {
                rootLevel=level;
                return true;
            }
            return rootLevel==level;
        }
        return checkLeaves(root.left,level+1) && checkLeaves(root.right,level+1);
    }

    static void invertTree(NodeTree root){
        if(root==null) return;
        invertTree(root.left);
        invertTree(root.right);
        NodeTree tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }

    public static void main(String[] args) {
        NodeTree root=new NodeTree(10);
        root.left=new NodeTree(9);
        root.right=new NodeTree(8);
        root.left.left=new NodeTree(6);
        root.left.right=new NodeTree(7);
        System.out.println(checkLeaves(root,0));
    }
}
