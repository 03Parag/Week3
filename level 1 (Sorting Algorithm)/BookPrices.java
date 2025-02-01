package Week3.Day03;

import java.util.Arrays;
// BookPrices class
class BookPrices {
    // Method to perform Merge Sort
    public static void mergeSort(double[] prices, int left, int right) {
        // If left is less than right, the array is already sorted
        if (left < right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted halves
    public static void merge(double[] prices, int left, int mid, int right) {
        // Size of the left and right halves
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Create temporary arrays
        double[] leftArr = new double[leftSize];
        double[] rightArr = new double[rightSize];

        // Copy data to temporary arrays
        System.arraycopy(prices, left, leftArr, 0, leftSize);
        System.arraycopy(prices, mid + 1, rightArr, 0, rightSize);

        // Initialize the leftArr, rightArr, and the original array
        int i = 0, j = 0, k = left;

        // Merge the two halves back into the original array
        while (i < leftSize && j < rightSize) {
            // If leftArr element is smaller or equal copy element from leftArr to original array
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                // Copy element from rightArr to original array
                prices[k++] = rightArr[j++];
            }
        }

        // Copy any remaining elements from leftArr
        while (i < leftSize) {
            prices[k++] = leftArr[i++];
        }

        // Copy any remaining elements from rightArr
        while (j < rightSize) {
            prices[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        // Create an array of book prices
        double[] bookPrices = {399.99, 249.50, 159.75, 499.99, 349.00, 199.99};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(bookPrices));

        // Sorting the book prices using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(bookPrices));
    }
}
