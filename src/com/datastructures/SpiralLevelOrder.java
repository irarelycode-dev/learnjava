package com.datastructures;

class NodeLevel{
    int key;
    NodeLevel left;
    NodeLevel right;
    public NodeLevel(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class SpiralLevelOrder {
    static int findHeight(NodeLevel root){
        if(root==null) return 0;
        int leftSubTreeHeight=findHeight(root.left)+1;
        int rightSubTreeHeight=findHeight(root.right)+1;
        return Math.max(leftSubTreeHeight,rightSubTreeHeight);
    }
    static void printTreeLevel(NodeLevel root,int level,int curr){
        if(level==curr) {
            System.out.println(root.key);
            return;
        }
        if(level%2==0){
            printTreeLevel(root.left,level,curr+1);
            printTreeLevel(root.right,level,curr+1);
        }else{
            printTreeLevel(root.right,level,curr+1);
            printTreeLevel(root.left,level,curr+1);
        }
    }
    static void spiralLevelOrder(NodeLevel root){
        int height=findHeight(root);
        for(int i=0;i<height;i++){  //O(n)
            printTreeLevel(root,i,0);
        }
    }
    public static void main(String[] args) {
        NodeLevel root=new NodeLevel(10);
        root.left=new NodeLevel(1);
        root.right=new NodeLevel(2);
        root.left.left=new NodeLevel(3);
        root.left.right=new NodeLevel(4);
        root.right.left=new NodeLevel(5);
        root.right.right=new NodeLevel(6);
        spiralLevelOrder(root);
    }
}
