package com.datastructures;
import java.util.Arrays;

class TreeNodeTest{
    int key;
    TreeNodeTest left;
    TreeNodeTest right;
    public TreeNodeTest(int key){
        this.key=key;
        this.left=this.right=null;
    }

    public TreeNodeTest(){}
}

public class ConstructBST {
    static int findNextGreaterElem(int[] arr,int low){
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[low]){
                index=i;
                break;
            }
        }
        return index;
    }
    static TreeNodeTest buildTreeUtil(int[] arr,int low,int high){
        if(arr.length==0 || low==high){
            return null;
        }
        System.out.println(low+" "+high);
        TreeNodeTest root=new TreeNodeTest(arr[low]);
        System.out.println(root.key);
        int nextGreaterElement=findNextGreaterElem(arr,low);
        root.left=buildTreeUtil(arr,low+1,nextGreaterElement-1);
        root.right=buildTreeUtil(arr,nextGreaterElement+1,arr.length-1);
        return root;
    }
    static TreeNodeTest buildTree(int[] arr){
       return buildTreeUtil(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr={10,5,1,7,40,50};
        TreeNodeTest root=buildTree(arr);
    }
}
