package com.collectionslearn;
import java.util.Stack;
import java.util.List;

public class StackLearn {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(10);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
