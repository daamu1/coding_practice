package com.damu.ds;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListInterceptor {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        final Map<Character, Integer> alphabetIndexMap = IntStream
                .rangeClosed('a', 'z')
                .boxed()
                .collect(Collectors.toMap(
                        c -> (char) c.intValue(),
                        c -> 0
                ));
        ListNode common = new ListNode(30);
        common.next = new ListNode(40);
        ListNode headA = new ListNode(10);
        headA.next = new ListNode(20);
        headA.next.next = common;
        ListNode headB = new ListNode(213);
        headB.next = common;
        ListNode intersectionNode = getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
