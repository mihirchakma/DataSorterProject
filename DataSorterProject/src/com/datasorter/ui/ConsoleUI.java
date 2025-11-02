package com.datasorter.ui;

import com.datasorter.model.SortPerformance;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        System.out.println("\n" + "=".repeat(58));
        System.out.println("  --- Data Sorter: Sorting Algorithm Comparison Tool ---");
        System.out.println("=".repeat(58));
        System.out.println("1. Enter numbers manually");
        System.out.println("2. Generate random numbers");
        System.out.println("3. Perform Bubble Sort");
        System.out.println("4. Perform Merge Sort");
        System.out.println("5. Perform Quick Sort");
        System.out.println("6. Compare all algorithms (show performance table)");
        System.out.println("7. Exit");
        System.out.println("-".repeat(58));
        System.out.print("Enter your choice: ");
    }

    public int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            return -1; // Invalid choice
        }
    }

    public void displaySortResults(SortPerformance performance) {
        System.out.println("\n--- " + performance.algoName + " Results ---");
        if (performance.sortedArray.length <= 50) {
            System.out.println("Sorted Output: " + Arrays.toString(performance.sortedArray));
        } else {
            System.out.println("Sorted Output: (Dataset is too large to display)");
        }
        System.out.printf("Execution Time: %.4f ms\n", performance.execTime);
        System.out.println("Steps (Comparisons): " + performance.steps);
    }

    public void displayComparisonTable(List<SortPerformance> results) {
        System.out.println("\n" + "=".repeat(65));
        System.out.printf("%-15s | %-20s | %-20s\n", "Algorithm", "Execution Time (ms)", "Steps (Comparisons)");
        System.out.println("-".repeat(65));
        for (SortPerformance res : results) {
            System.out.printf("%-15s | %-20.4f | %-20d\n", res.algoName, res.execTime, res.steps);
        }
        System.out.println("=".repeat(65));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String error) {
        System.out.println("\nError: " + error);
    }
}