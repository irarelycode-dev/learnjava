package com.datastructures;

class MyNode4{
    MyNode4 left;
    MyNode4 right;
    int key;
    public MyNode4(int key){
        this.key=key;
    }
}

public class Diameter {

    static int diameter;
    static MyNode4 largestDiameterRoot;
    static String leftSubTree;
    static String rightSubTree;
    static int findDiameter(MyNode4 root){
        if(root==null) return 0;
        int leftHeight=findDiameter(root.left)+1;
        int rightHeight=findDiameter(root.right)+1;
        if(diameter<leftHeight+rightHeight){
            largestDiameterRoot=root;
        }
        diameter=Math.max(diameter,leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        MyNode4 root=new MyNode4(10);
        root.left=new MyNode4(2);
        root.right=new MyNode4(8);
        root.left.left=new MyNode4(12);
        root.left.right=new MyNode4(132);
        findDiameter(root);
    }
}
