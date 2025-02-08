package Week3.Day05;
// Create LinearAndBinarySearch class to find the first missing positive integer and return index of the target element
class LinearAndBinarySearch {
    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        // Store the length of array in n variable
        int n = arr.length;

        // Loop through the length of array
        for (int i = 0; i < n; i++) {
            // Check if the array value is positive and within n variable and 2 value are not equal
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with the correct position arr[arr[i] - 1]
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                // Missing positive integer
                return i + 1;
            }
        }

        // If all numbers are present in sequence
        return n + 1;
    }

    // Method to perform Binary Search and return index of the target element
    public static int binarySearch(int[] arr, int target) {
        // Initialize left to 0
        int left = 0, right = arr.length - 1;

        // If left is lesser than or equal right
        while (left <= right) {
            // Find the mid
            int mid = left + (right - left) / 2;
            // If middle value of array is target
            if (arr[mid] == target) {
                // Target found
                return mid;
            } else if (arr[mid] < target) {
                // Search right half
                left = mid + 1;
            } else {
                // Search left half
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    // Simple Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        // Store the length of array in n variable
        int n = arr.length;
        // Loop through the length of array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // If arr[j] value is greater than arr[j+1]
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = {3, 4, -1, 1, 7, 2, 8, 5};
        // Enter the target
        int target = 4;

        // Find first missing positive integer
        int missingPositive = findFirstMissingPositive(numbers);

        // Print the missing positive
        System.out.println("First Missing Positive Integer: " + missingPositive);

        // Sort the array using Bubble Sort for binary search
        bubbleSort(numbers);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        // Perform binary search for the target element
        int targetIndex = binarySearch(numbers, target);

        // Print the target index
        System.out.println("Target Index: " + targetIndex);
    }
}
