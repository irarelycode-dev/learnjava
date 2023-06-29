package com.datastructures;

public class FindParent {

    static class Node{
        int key;
        Node left;
        Node right;
        Node(int key){
            this.key=key;
            this.left=null;
            this.right=null;
        }
        @Override
        public String toString(){
            return "Key:"+this.key;
        }
    }

    public static Node findParent(Node node,Node target,Node parent){
        if(node==null) return parent;
        if(node.key==target.key) return parent;
        Node left=findParent(node.left,target,node);
        Node right=findParent(node.right,target,node);
        return left==null?right:left;
    }

    public static void main(String[] args) {
        FindParent ins=new FindParent();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        Node parent=findParent(root,root.left.left,null);
        System.out.println(parent);
    }

}
