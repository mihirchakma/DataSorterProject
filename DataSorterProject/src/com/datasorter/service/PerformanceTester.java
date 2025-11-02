package com.datasorter.service;

import com.datasorter.algorithms.BubbleSort;
import com.datasorter.algorithms.MergeSort;
import com.datasorter.algorithms.QuickSort;
import com.datasorter.model.SortPerformance;
import com.datasorter.model.SortResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerformanceTester {

    public SortPerformance performAndMeasureSort(String algoName, int[] data) {
        int[] dataCopy = Arrays.copyOf(data, data.length);
        SortResult result;

        long startTime = System.nanoTime();

        switch (algoName) {
            case "Bubble Sort" -> result = BubbleSort.sort(dataCopy);
            case "Merge Sort" -> result = MergeSort.sort(dataCopy);
            case "Quick Sort" -> result = QuickSort.sort(dataCopy);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algoName);
        }

        long endTime = System.nanoTime();
        double execTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        return new SortPerformance(algoName, execTime, result.steps, result.sortedArray);
    }

    public List<SortPerformance> compareAllAlgorithms(int[] data) {
        List<SortPerformance> results = new ArrayList<>();

        results.add(performAndMeasureSort("Bubble Sort", data));
        results.add(performAndMeasureSort("Merge Sort", data));
        results.add(performAndMeasureSort("Quick Sort", data));

        return results;
    }
}