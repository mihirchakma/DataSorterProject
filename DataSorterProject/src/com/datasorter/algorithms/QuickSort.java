package com.datasorter.algorithms;

import com.datasorter.model.SortResult;

public class QuickSort {

    public static SortResult sort(int[] arr) {
        long[] stepsCounter = {0};
        quickSortRecursive(arr, 0, arr.length - 1, stepsCounter);
        return new SortResult(arr, stepsCounter[0]);
    }

    private static void quickSortRecursive(int[] arr, int low, int high, long[] stepsCounter) {
        if (low < high) {
            int pi = partition(arr, low, high, stepsCounter);
            quickSortRecursive(arr, low, pi - 1, stepsCounter);
            quickSortRecursive(arr, pi + 1, high, stepsCounter);
        }
    }

    private static int partition(int[] arr, int low, int high, long[] stepsCounter) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            stepsCounter[0]++;
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}