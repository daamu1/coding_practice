package com.damu.ds;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values = {111, 2, 3, 5, 6, 7, 7, 8};
        System.out.println(Arrays.toString(bubbleSort(values)));
    }

    private static int[] bubbleSort(int[] values) {
        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        return values;
    }
}
