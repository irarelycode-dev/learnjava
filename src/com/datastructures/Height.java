package com.datastructures;

class MyNode3{
    MyNode3 left;
    MyNode3 right;
    int key;
    public MyNode3(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class Height {
    static int height(MyNode3 root){
        if(root==null) return 0;
        int leftHeight=height(root.left)+1;
        int rightHeight=height(root.right)+1;
        return Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
        MyNode3 root=new MyNode3(10);
        root.left=new MyNode3(8);
        root.right=new MyNode3(6);
        root.left.left=new MyNode3(5);
        root.left.right=new MyNode3(2);
        System.out.println(height(root));
    }
}
