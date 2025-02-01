package Week3.Day03;

import java.util.Arrays;
// ProductPrices class
class ProductPrices {
    // Method to perform Quick Sort
    public static void quickSort(double[] prices, int low, int high) {
        // If low is less than high, the array is already sorted
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Method to partition the array
    public static int partition(double[] prices, int low, int high) {
        // Choosing last element as pivot
        double pivot = prices[high];
        // Index for smaller element
        int i = low - 1;

        // Loop through the subarray from low to high
        for (int j = low; j < high; j++) {
            // If an element is less than the pivot, increment i and swap the element with the one at index i
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }

        // Swap pivot to its correct position
        swap(prices, i + 1, high);
        // Return pivot index
        return i + 1;
    }

    // Method to swap two elements in the array
    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Create an array of product prices
        double[] productPrices = {599.99, 299.50, 149.75, 899.99, 499.00, 199.99};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(productPrices));

        // Sorting the product prices using Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(productPrices));
    }
}
