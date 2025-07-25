package com.damu.ds;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.capacity());
        System.out.println(stack.capacity());
        stack.add(30,101);
        for (Integer integer : stack) {
            System.out.println(integer);
            stack.pop();
        }

//        stack.push(1);
//        stack.push(2);
//        for (Integer integer : stack) {
//            System.out.println(integer);
//            stack.pop();
//        }
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.capacity());
//        System.out.println(stack.search(2));
//        System.out.println(stack.peek());
    }

}
