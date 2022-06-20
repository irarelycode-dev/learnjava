package com.datastructures;

class TNode{
    TNode left;
    TNode right;
    int elem;
    public TNode(int elem){
        this.elem=elem;
        this.left=this.right=null;
    }
}

public class TreeTraversalStacks {

    static Object[] printInorderTree(TNode node){
        if(node==null) return new Object[0];
        java.util.Stack<TNode> stack=new java.util.Stack<>();
        java.util.List<Integer> al=new java.util.ArrayList<>();
        stack.push(node);
        node=node.left;
        while(stack.size()!=0 || node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            TNode curr=stack.pop();
            al.add(curr.elem);
            node=curr.right;
        }
        return al.toArray();
    }

    static Object[] printPreorderTree(TNode node){
        if(node==null) return new Object[0];
        java.util.Stack<TNode> stack=new java.util.Stack<>();
        java.util.List<Integer> al=new java.util.ArrayList<>();
        stack.push(node);
        while(stack.size()!=0){
            TNode popped=stack.pop();
            al.add(popped.elem);
            stack.push(popped.right);
            stack.push(popped.left);
        }
        return al.toArray();
    }

    static Object[] printPostorder(TNode node){
        if(node==null) return new Object[0];
        java.util.Stack<TNode> stack1=new java.util.Stack<>();
        java.util.Stack<TNode> stack2=new java.util.Stack<>();
        stack1.push(node);
        while(stack1.size()!=0){
            TNode curr=stack1.pop();
            stack1.push(curr.left);
            stack1.push(curr.right);
            stack2.push(curr);
        }
        return stack2.toArray();
    }

    public static void main(String[] args) {
        TNode root=new TNode(10);
        root.left=new TNode(12);
        root.left.left=new TNode(13);
        root.left.right=new TNode(14);
        root.right=new TNode(15);
        root.right.left=new TNode(16);
        Object[] array=printInorderTree(root);
        for(Object obj:array){
            System.out.println(obj);
        }
        printPostorder(root);
    }
}
