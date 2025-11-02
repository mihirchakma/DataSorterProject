package com.datasorter.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataHandler {

    private final List<Integer> dataset = new ArrayList<>();
    private final Scanner scanner;

    public DataHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void enterNumbersManually() {
        System.out.println("Enter numbers separated by spaces (e.g., 5 2 9 1):");
        String line = scanner.nextLine();
        String[] parts = line.split("\\s+");
        dataset.clear();
        try {
            for (String part : parts) {
                if (!part.isEmpty()) {
                    dataset.add(Integer.valueOf(part));
                }
            }
            if (dataset.isEmpty()) {
                System.out.println("Error: No numbers were entered.");
            } else {
                System.out.println("Dataset created: " + dataset);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
            dataset.clear();
        }
    }

    public void generateRandomNumbers() {
        try {
            System.out.print("Enter the number of random integers: ");
            int size = scanner.nextInt();
            System.out.print("Enter the minimum value: ");
            int min = scanner.nextInt();
            System.out.print("Enter the maximum value: ");
            int max = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (size <= 0) {
                System.out.println("Error: Size must be positive.");
                return;
            }
            if (min > max) {
                System.out.println("Error: Minimum cannot be greater than maximum.");
                return;
            }

            Random rand = new Random();
            dataset.clear();
            for (int i = 0; i < size; i++) {
                dataset.add(rand.nextInt(max - min + 1) + min);
            }

            System.out.println(size + " random numbers generated.");
            if (size <= 50) {
                System.out.println("Dataset: " + dataset);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    public boolean datasetIsEmpty() {
        return dataset.isEmpty();
    }

    public int[] getDatasetAsArray() {
        return dataset.stream().mapToInt(i -> i).toArray();
    }
}