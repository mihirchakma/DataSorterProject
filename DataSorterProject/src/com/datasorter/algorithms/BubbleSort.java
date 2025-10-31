package com.datasorter.algorithms;

import com.datasorter.model.SortResult;

public class BubbleSort {
    public static SortResult sort(int[] arr) {
        long steps = 0;
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return new SortResult(arr, steps);
    }
}