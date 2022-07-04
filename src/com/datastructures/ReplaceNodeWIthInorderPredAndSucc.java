package com.datastructures;
import java.util.ArrayList;

class TreeNde{
    TreeNde left;
    TreeNde right;
    int val;
    public TreeNde(int val){
        this.val=val;
    }
}

public class ReplaceNodeWIthInorderPredAndSucc {
    static class INT{
        int data;
    }
    public ArrayList<Integer> fillNodes(TreeNde root,ArrayList<Integer> al){
        if(root==null) return al;
        fillNodes(root.left,al);
        al.add(root.val);
        fillNodes(root.right,al);
        return al;
    }
    public void replaceNode(TreeNde root,ArrayList<Integer> al,INT i){
        if(root==null) return;
        replaceNode(root.left,al,i);
        root.val=al.get(i.data-1)+al.get(i.data+1);
        i.data++;
        replaceNode(root.right,al,i);
    }
    public void replaceNodeWithInorderPredAndSucc(TreeNde root,INT i){
        ArrayList<Integer> al=new ArrayList<>();
        al.add(0);
        al=fillNodes(root,al);
        al.add(0);
        System.out.println(al);
        replaceNode(root,al,i);
    }
    public void printPreorder(TreeNde root){
        if(root==null) return;
        System.out.println(root.val);
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void main(String[] args) {
        TreeNde root=new TreeNde(1);
        ReplaceNodeWIthInorderPredAndSucc thisObject=new ReplaceNodeWIthInorderPredAndSucc();
        INT i=new INT();
        i.data=1;
        root.left=new TreeNde(2);
        root.right=new TreeNde(3);
        root.left.left=new TreeNde(4);
        root.left.right=new TreeNde(5);
        root.right.left=new TreeNde(6);
        root.right.right=new TreeNde(7);
        thisObject.replaceNodeWithInorderPredAndSucc(root,i);
        thisObject.printPreorder(root);
    }
}
