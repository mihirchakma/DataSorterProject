package com.datasorter.model;

/**
 * A simple class to hold the result of a sort operation,
 * including the sorted array and the number of steps (comparisons).
 */

public class SortResult {
    public int[] sortedArray;
    public long steps;

    public SortResult(int[] sortedArray, long steps) {
        this.sortedArray = sortedArray;
        this.steps = steps;
    }
}