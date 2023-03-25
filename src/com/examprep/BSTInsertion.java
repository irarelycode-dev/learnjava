package com.examprep;

class Node{
    int key;
    Node left;
    Node right;
    public Node(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class BSTInsertion {

    public static Node insertNode(int key,Node root){
        Node curr=root;
        if(curr==null){
            root=new Node(key);
            return root;
        }
        Node parent=root;
        while(curr!=null){
            if(key<curr.key){
                parent=curr;
                curr=curr.left;
            }else if(key>curr.key){
                parent=curr;
                curr=curr.right;
            }else{
                return null;
            }
        }
        if(key<parent.key){
            parent.left=new Node(key);
        }else{
            parent.right=new Node(key);
        }
        return root;
    }

    public static int getMin(Node root){
        if(root.left==null && root.right==null) return root.key;
        return getMin(root.left);
    }
    public static Node deleteNode(int key,Node root){
        if(root==null) return null;
        else if(root.key>key){
            root.left=deleteNode(key,root.left);
        }else if(root.key<key){
            root.right=deleteNode(key,root.right);
        }else{
            if(root.right==null) return root.left;
            else if(root.left==null) return root.right;
            else{
                root.key=getMin(root.right);
                root.right=deleteNode(key,root.right);
            }
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null) return;
        if(root.left!=null) root=root.left;
        System.out.println(root.key);
        if(root.right!=null) root=root.right;
    }

    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(12);
        Node newNode=insertNode(15,root);
        System.out.println(root.key);
        System.out.println(root.left.key);
        System.out.println(root.right.key);
        System.out.println(root.right.right.key);
    }
}
