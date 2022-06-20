package com.datastructures;

class NodeTreeSub{
    NodeTreeSub left;
    NodeTreeSub right;
    int key;
    public NodeTreeSub(int key){
        this.left=this.right=null;
        this.key=key;
    }
}

public class LowestCommonAncestor {
    static NodeTreeSub lowestCommonAncestor(NodeTreeSub root,NodeTreeSub q,NodeTreeSub p){
        if(root==null || root==p || root==q) return root;
        NodeTreeSub left=lowestCommonAncestor(root.left,q,p);
        NodeTreeSub right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null) return null;
        if(left!=null && right!=null) return root;
        return left==null?right:left;
    }
    public static void main(String[] args) {

    }
}
