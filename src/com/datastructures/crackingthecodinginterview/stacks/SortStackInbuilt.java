package com.datastructures.crackingthecodinginterview.stacks;

import java.util.Deque;

public class SortStackInbuilt {

    public Deque<Integer> sortStack(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int poll = stack.poll();
        stack = sortStack(stack);
        insertElement(stack, poll);
        return stack;
    }

    private Deque<Integer> insertElement(Deque<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
            return stack;
        }
        int poll = stack.poll();
        insertElement(stack, element);
        stack.push(poll);
        return stack;
    }

}
