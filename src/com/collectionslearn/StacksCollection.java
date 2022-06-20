package com.collectionslearn;
import java.util.Iterator;
import java.util.Stack;

public class StacksCollection {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(100);
        stack.push(10);
        System.out.println("print stack:"+stack);
        System.out.println("peek:"+stack.peek());
        stack.pop();
        System.out.println("popped stack:"+stack);
        Iterator<Integer> itr=stack.iterator();
        while(itr.hasNext()){
            System.out.println("iterator:"+itr.next());
        }
    }
}
