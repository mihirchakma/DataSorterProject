package com.datasorter.algorithms;

import com.datasorter.model.SortResult;

public class MergeSort 
{

    public static SortResult sort(int[] arr) 
    {
        long[] stepsCounter = {0};
        mergeSortRecursive(arr, 0, arr.length - 1, stepsCounter);
        return new SortResult(arr, stepsCounter[0]);
    }

    private static void mergeSortRecursive(int[] arr, int left, int right, long[] stepsCounter)
     {
        if (left < right) 
        {
            int mid = (left + right) / 2;
            mergeSortRecursive(arr, left, mid, stepsCounter);
            mergeSortRecursive(arr, mid + 1, right, stepsCounter);
            merge(arr, left, mid, right, stepsCounter);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, long[] stepsCounter)
     {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) 
        {
            stepsCounter[0]++;
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            } 
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}