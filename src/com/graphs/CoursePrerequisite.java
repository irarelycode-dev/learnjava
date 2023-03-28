package com.graphs;

import java.util.*;

public class CoursePrerequisite {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(isPossible(prerequisites));
    }

    private static boolean topologicalSort(Map<Integer, ArrayList<Integer>> adjList) {
        Integer[] nodes = adjList.keySet().toArray(new Integer[0]);
        HashMap<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>();

        //calculate indegree of each vertex
        for (int i = 0; i < nodes.length; ++i) {
            int count = 0;
            for (int j = 0; j < nodes.length; ++j) {
                if (i != j && adjList.get(nodes[j]).contains(i)) count++;
            }
            indegree.putIfAbsent(nodes[i], count);
            if (count == 0 && q.size() == 0) q.add(nodes[i]);
        }

        //storing result in LinkedList<>
        int count = 0;
        while (q.size() != 0) {
            int tmp = q.poll();
            indegree.put(tmp, -1);
            count++;
            for (Integer neighbor : adjList.get(tmp)) {
                int degree = indegree.get(neighbor);
                indegree.put(neighbor, degree - 1);
                if (indegree.get(neighbor) == 0) q.add(neighbor);
            }
        }

        //check if count is equal to size of nodes
        return count == nodes.length;
    }

    public static boolean isPossible(int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] pair : prerequisites) {
            int node1 = pair[0];
            int node2 = pair[1];
            ArrayList<Integer> al;
            if (!adjList.containsKey(node1)) {
                al = new ArrayList<>();
                al.add(node2);
                adjList.put(node1, al);
            } else {
                adjList.get(node1).add(node2);
            }
            if (!adjList.containsKey(node2)) {
                adjList.putIfAbsent(node2, new ArrayList<>());
            }
        }
        return topologicalSort(adjList);
    }
}
