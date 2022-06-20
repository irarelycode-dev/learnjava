package com.datastructures;

class MyNode2{
    MyNode2 left;
    MyNode2 right;
    int key;
    public MyNode2(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class OddLevelNodes {
    static void printOddLevels(MyNode2 root,boolean isOdd){
        if(root==null) return;
        if(isOdd) System.out.println(root.key);
        printOddLevels(root.left,!isOdd);
        printOddLevels(root.right,!isOdd);
    }
    public static void main(String[] args) {
        MyNode2 root=new MyNode2(10);
        root.left=new MyNode2(2);
        root.left.left=new MyNode2(8);
        root.right=new MyNode2(6);
        root.left.right=new MyNode2(12);
        printOddLevels(root,true);
    }
}
