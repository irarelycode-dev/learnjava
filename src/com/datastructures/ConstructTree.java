package com.datastructures;

import java.util.Arrays;

class NodeTreeMy{
    NodeTreeMy left;
    NodeTreeMy right;
    char key;
    public NodeTreeMy(char key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class ConstructTree {
    static int preIndex=0;
    static int search(char[] inorder,char searchKey){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==searchKey) return i;
        }
        return -1;
    }

    public static NodeTreeMy constructTree(char inorder[],char preorder[],int start,int end){
        if(start>end) return null;
        NodeTreeMy node=new NodeTreeMy(preorder[preIndex++]);
        if(start==end) return node;
        int rootIndex=search(inorder,node.key);
        node.left=constructTree(inorder,preorder,start,rootIndex-1);
        node.right=constructTree(inorder,preorder,rootIndex+1,end);
        return node;
    }

    public static void main(String[] args) {
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        NodeTreeMy root=constructTree(in,pre,0,in.length-1);
        System.out.println(root.key);
        System.out.println(root.left.key);
        System.out.println(root.right.key);
        System.out.println(root.right.left.key);
    }
}
