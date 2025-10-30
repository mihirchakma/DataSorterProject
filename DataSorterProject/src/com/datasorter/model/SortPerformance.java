package com.datasorter.model;

/**
 * Holds the complete results of a single sort test.
 */

public class SortPerformance {
    public String algoName;
    public double execTime;
    public long steps;
    public int[] sortedArray;

    public SortPerformance(String algoName, double execTime, long steps, int[] sortedArray) {
        this.algoName = algoName;
        this.execTime = execTime;
        this.steps = steps;
        this.sortedArray = sortedArray;
    }
}