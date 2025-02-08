package Week3.Day05;
// Create FirstLastOccurrence class to find the first and last occurrence
class FirstLastOccurrence {
    // Method to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        // Initialize left to 0
        int left = 0, right = arr.length - 1;
        // Default if not found
        int firstOccurrence = -1;

        // If left is lesser than or equal right
        while (left <= right) {
            // Find the mid
            int mid = left + (right - left) / 2;

            // If middle value of array is target
            if (arr[mid] == target) {
                // First occurrence found
                firstOccurrence = mid;
                // Search in left half for earlier occurrences
                right = mid - 1;
            // If middle value of array is less than target
            } else if (arr[mid] < target) {
                // Search in right half
                left = mid + 1;
            } else {
                // Search in left half
                right = mid - 1;
            }
        }

        //Return the first occurrence
        return firstOccurrence;
    }

    // Method to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        // Initialize left to 0
        int left = 0, right = arr.length - 1;
        // Default if not found
        int lastOccurrence = -1;

        // If left is lesser than or equal right
        while (left <= right) {
            // Find the mid
            int mid = left + (right - left) / 2;

            // If middle value of array is target
            if (arr[mid] == target) {
                // Last occurrence found
                lastOccurrence = mid;
                // Search in left half for earlier occurrences
                right = mid - 1;
                // If middle value of array is less than target
            } else if (arr[mid] < target) {
                // Search in right half
                left = mid + 1;
            } else {
                // Search in left half
                right = mid - 1;
            }
        }

        //Return the last occurrence
        return lastOccurrence;
    }

    // Method to find both first and last occurrences
    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        // Call the findFirstOccurrence(arr, target) and findLastOccurrence(arr, target) method
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        // Return array with first and last indices
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = {2, 4, 4, 4, 7, 9, 10};
        // Enter the target
        int target = 4;

        // Call the method to find both first and last occurrences
        int[] result = findFirstAndLastOccurrence(numbers, target);

        // Print the First and last occurrence
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}

