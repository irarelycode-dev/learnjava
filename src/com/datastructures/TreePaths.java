package com.datastructures;

class MyNode{
    MyNode left;
    MyNode right;
    int key;
    public MyNode(int key){
        this.key=key;
        this.right=this.left=null;
    }
}

public class TreePaths {
    static void printNodes(java.util.List<Integer> al){
        System.out.println(al);
    }
    static void printTreePaths(MyNode root,java.util.List<Integer> al){
        if(root==null) return;
        al.add(root.key);
        if(root.left==null&&root.right==null){
            printNodes(al);
            al.remove(al.size()-1);
        }else {
            printTreePaths(root.left, al);
            printTreePaths(root.right, al);
        }
    }

    public static void main(String[] args) {
        java.util.List<Integer> al=new java.util.ArrayList<>();
        MyNode root = new MyNode(10);
        root.left = new MyNode(8);
        root.right = new MyNode(2);
        root.left.left = new MyNode(3);
        root.left.right = new MyNode(5);
        root.right.left = new MyNode(2);
        printTreePaths(root,al);
    }
}
