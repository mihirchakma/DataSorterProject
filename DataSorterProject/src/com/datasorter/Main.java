package com.datasorter;

import com.datasorter.model.SortPerformance;
import com.datasorter.service.DataHandler;
import com.datasorter.service.PerformanceTester;
import com.datasorter.ui.ConsoleUI;

import java.util.List;
import java.util.Scanner;

/**
 * Main controller for the Sorting Algorithm Comparison Tool.
 * Connects the UI, DataHandler, and PerformanceTester.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);
        DataHandler dataHandler = new DataHandler(scanner);
        PerformanceTester tester = new PerformanceTester();

        while (true) {
            ui.printMenu();
            int choice = ui.getUserChoice();

            switch (choice) {
                case 1 -> dataHandler.enterNumbersManually();
                case 2 -> dataHandler.generateRandomNumbers();
                case 3 -> // Bubble Sort
                    performSingleSort("Bubble Sort", dataHandler, tester, ui);
                case 4 -> // Merge Sort
                    performSingleSort("Merge Sort", dataHandler, tester, ui);
                case 5 -> // Quick Sort
                    performSingleSort("Quick Sort", dataHandler, tester, ui);
                case 6 -> {
                    // Compare All
                    if (dataHandler.datasetIsEmpty()) {
                        ui.printError("No data to sort. Please create a dataset first.");
                        continue;
                    }
                    ui.printMessage("\nComparing all algorithms...");
                    List<SortPerformance> results = tester.compareAllAlgorithms(dataHandler.getDatasetAsArray());
                    ui.displayComparisonTable(results);
                }
                case 7 -> {
                    ui.printMessage("Exiting the Data Sorter. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> ui.printError("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private static void performSingleSort(String algoName, DataHandler dataHandler,
                                          PerformanceTester tester, ConsoleUI ui) {
        if (dataHandler.datasetIsEmpty()) {
            ui.printError("No data to sort. Please create a dataset first.");
            return;
        }
        SortPerformance result = tester.performAndMeasureSort(algoName, dataHandler.getDatasetAsArray());
        ui.displaySortResults(result);
    }
}