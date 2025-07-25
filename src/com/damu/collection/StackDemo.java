package com.damu.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // Using Stack class (extends Vector, synchronized)
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // add to top
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack: " + stack); // [1, 2, 3, 4, 5]

        Integer removedElement = stack.pop(); // removes 5
        System.out.println("After pop: " + stack); // [1, 2, 3, 4]

        Integer peek = stack.peek(); // views 4 (top element)
        System.out.println("Peek: " + peek); // 4
        System.out.println("Stack after peek: " + stack); // [1, 2, 3, 4]

        System.out.println("Is empty? " + stack.isEmpty()); // false
        System.out.println("Size: " + stack.size()); // 4

        int search = stack.search(3); // returns position from top (1-based)
        System.out.println("Search 3: " + search); // e.g., 2 if 3 is 2nd from top

        // Using LinkedList as a Stack
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1); // push
        linkedList.addLast(2);
        linkedList.addLast(3);
        System.out.println("LinkedList (as stack): " + linkedList);

        Integer top = linkedList.getLast(); // peek
        System.out.println("Peek (LinkedList): " + top);

        linkedList.removeLast(); // pop
        System.out.println("After pop (LinkedList): " + linkedList);

        System.out.println("Size: " + linkedList.size());
        System.out.println("Is empty? " + linkedList.isEmpty());

        // Using ArrayList as a Stack (manual)
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1); // push
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList (as stack): " + arrayList);

        Integer arrayTop = arrayList.get(arrayList.size() - 1); // peek
        System.out.println("Peek (ArrayList): " + arrayTop);

        arrayList.remove(arrayList.size() - 1); // pop
        System.out.println("After pop (ArrayList): " + arrayList);
    }
}
/*
 * - Stack (legacy, synchronized) uses push(), pop(), peek(), search().
 * - LinkedList can act as a stack using addLast() and removeLast().
 * - ArrayList can mimic stack behavior with add(), get(size-1), remove(size-1).
 * - Prefer Deque (like ArrayDeque) over Stack for better performance and flexibility.
 * - Stack uses LIFO (Last In First Out) principle.
 */
