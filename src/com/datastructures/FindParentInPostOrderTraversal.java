package com.datastructures;

import java.util.Arrays;

public class FindParentInPostOrderTraversal {

    private static void findParent(int[] postOrder, int parent) {
        System.out.println(Arrays.toString(postOrder));
        int rootIndex = postOrder.length - 1;
        int root = postOrder[rootIndex];
        System.out.println("root has a parent:" + root + " " + parent);
        if (postOrder.length == 1) return;
        findParent(Arrays.copyOfRange(postOrder, 0, (rootIndex - 1) / 2 + 1), root);
        findParent(Arrays.copyOfRange(postOrder, (rootIndex - 1) / 2 + 1, rootIndex), root);
    }


    public static void main(String[] args) {
        int[] postOrder = {1, 2, 3, 4, 5, 6, 7};
        findParent(postOrder, -1);
    }
}
