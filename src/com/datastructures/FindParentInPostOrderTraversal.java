package com.datastructures;

import java.util.Arrays;

public class FindParentInPostOrderTraversal {

    private static void findParent(int[] postOrder, int parent, int target) {
        if (postOrder.length == 0) return;
        int rootIndex = postOrder.length - 1;
        int currentLevelRoot = postOrder[rootIndex];
        if (target == currentLevelRoot) {
            System.out.println("Node has a parent:" + currentLevelRoot + " " + parent);
        }
        if (postOrder.length == 1) return;
        findParent(Arrays.copyOfRange(postOrder, 0, (rootIndex - 1) / 2 + 1), currentLevelRoot, target);
        findParent(Arrays.copyOfRange(postOrder, (rootIndex - 1) / 2 + 1, rootIndex), currentLevelRoot, target);
    }


    public static void main(String[] args) {
        int[] postOrder = {1, 2, 3, 4, 5, 6, 7};
        findParent(postOrder, -1, 5);
    }
}
