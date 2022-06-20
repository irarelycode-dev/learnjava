package com.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

class TreeNodeSome{
    TreeNodeSome left;
    TreeNodeSome right;
    int key;
    public TreeNodeSome(int key){
        this.left=this.right=null;
        this.key=key;
    }
}

public class ReversePath {
    static ArrayList<TreeNodeSome> al=new ArrayList<>();
    static Integer[][] list=new Integer[1][];
    static void findPath(TreeNodeSome root,int searchKey){
        if(root==null) return;
        if(root.key==searchKey){
//            list.add(al);
            return;
        }
        al.add(root);
        findPath(root.left,searchKey);
        findPath(root.right,searchKey);
        al.remove(al.size()-1);
    }
    public static void main(String[] args) {
        TreeNodeSome root=new TreeNodeSome(10);
        root.left=new TreeNodeSome(2);
        root.right=new TreeNodeSome(14);
        root.right.left=new TreeNodeSome(12);
        findPath(root,12);
        System.out.println(list);
    }
}
