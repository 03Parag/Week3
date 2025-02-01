package Week3.Day03;

import java.util.Arrays;
// SalaryDemands class
class SalaryDemands {
    // Method to perform Heap Sort
    public static void heapSort(double[] salaries) {
        // Store the length of the salaries array
        int n = salaries.length;

        // Build a Max Heap through iteration
        for (int i = n / 2 - 1; i >= 0; i--) {
            // Heapify each subtree to ensure max heap is created
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to the end
            swap(salaries, 0, i);

            // Call heapify on reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to maintain the max heap property
    public static void heapify(double[] salaries, int heapSize, int root) {
        // Assume root is largest and calculate the left child and right child
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        // Check if left child is larger than root
        if (leftChild < heapSize && salaries[leftChild] > salaries[largest]) {
            largest = leftChild;
        }

        // Check if right child is larger than largest so far
        if (rightChild < heapSize && salaries[rightChild] > salaries[largest]) {
            largest = rightChild;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != root) {
            swap(salaries, root, largest);
            heapify(salaries, heapSize, largest);
        }
    }

    // Method to swap two elements in the array
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Create an array of salary demands
        double[] salaryDemands = {55000, 75000, 48000, 90000, 67000, 82000};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(salaryDemands));

        // Sorting the salary demands using Heap Sort
        heapSort(salaryDemands);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(salaryDemands));
    }
}

