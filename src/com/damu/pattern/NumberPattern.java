package com.damu.pattern;

import java.util.ArrayList;
import java.util.List;

public class NumberPattern {

    public static void main(String[] args) {

        System.out.println(printPat(3));
    }

    public static ArrayList<Integer> printPat(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                integers.add(i);
            }
        }
        return integers;
    }
}
