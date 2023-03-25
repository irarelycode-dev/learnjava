package com.examprep;

import java.util.*;

public class pseudocodes {

    public static void main(String[] args) {
//        bfs graphs
//        BFS(Node root)
//        create queue
//        create empty list of visited nodes
//        mark root node as visited
//        enqueue root node
//        while (queue is not empty){
//            x = queue.deque();
//            for (all immediate neighbours of x){
//                mark immediate as visited
//                enqueue immediate
//            }
//        }




//        dfs graphs
//
//        dfs(v){
//            mark[v]=1
//            print v
//            for each (v,u) belongs to Adj[v]
//                if(mark[u]==0){
//                    dfs(u)
//                }
//        }




        class Experiment {

            public static <E> void funct1(final List<E> list1, final E something) {
                list1.add(something);
            }

            public static void funct2(final List<?> list, final Object something) {
//                list.add(something); // does not compile
            }
        }

    }

}
