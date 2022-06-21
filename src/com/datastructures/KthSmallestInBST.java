package com.datastructures;

class TreeNodeKth{
    TreeNodeKth left;
    TreeNodeKth right;
    int key;
    public TreeNodeKth(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class KthSmallestInBST {
    private int count=0;
    TreeNodeKth node;
    void KthNode(TreeNodeKth root,int k){
        if(root==null) return;
        KthNode(root.left,k);
        count++;
        if(count==k) node=root;
        KthNode(root.right,k);
    }
    public static void main(String[] args) {
        KthSmallestInBST object=new KthSmallestInBST();
        TreeNodeKth root=new TreeNodeKth(5);
        root.left=new TreeNodeKth(2);
        root.left.left=new TreeNodeKth(-4);
        root.left.right=new TreeNodeKth(3);
        root.right=new TreeNodeKth(18);
        object.KthNode(root,4);
        System.out.println(object.node.key);
    }
}
