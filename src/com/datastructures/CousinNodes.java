package com.datastructures;

class NodeTree2{
    int key;
    NodeTree2 left;
    NodeTree2 right;
    public NodeTree2(int key){
        this.key=key;
        this.left=this.right=null;
    }
}

public class CousinNodes {
    static int findLevel(NodeTree2 root,NodeTree2 target,int level){
        if(root==null) return 0;
        if(root.equals(target)){
            return level;
        }
        int lvl=findLevel(root.left,target,level+1);
        if(lvl!=0) return lvl;
        return findLevel(root.right,target,level+1);
    }
    static boolean hasSameParent(NodeTree2 node,NodeTree2 p,NodeTree2 q){
        if(node==null) return false;
        return node.left==p && node.right==q || node.left==q && node.right==p || hasSameParent(node.left,p,q) || hasSameParent(node.right,p,q);
    }
    static boolean cousinNodes(NodeTree2 root,NodeTree2 p,NodeTree2 q){
        return findLevel(root,p,0)==findLevel(root,q,0) && hasSameParent(root,p,q);
    }
    public static void main(String[] args) {
        NodeTree2 root=new NodeTree2(10);
        root.left=new NodeTree2(12);
        root.right=new NodeTree2(7);
        root.left.left=new NodeTree2(10);
        System.out.println(cousinNodes(root,root.left,root.right));
    }
}
