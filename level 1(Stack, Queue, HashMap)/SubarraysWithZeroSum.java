package Week3.Day02;

import java.util.HashMap;

// SubarraysWithZeroSum class
class SubarraysWithZeroSum {

    // Method to find all subarrays with zero sum
    public int findZeroSumSubarrays(int[] arr) {
        // HashMap to store the cumulative sum and its indices
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize cumulative sum and count of zero-sum subarrays
        int cumulativeSum = 0;
        int count = 0;

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // Update cumulative sum
            cumulativeSum += arr[i];

            // If cumulative sum is 0, we found a subarray from index 0 to i
            if (cumulativeSum == 0) {
                System.out.println("Subarray found from index " + 0 + " to " + i);
                count++;
            }

            // If cumulative sum has been seen before, we have found a subarray from the previous index
            if (map.containsKey(cumulativeSum)) {
                int start = map.get(cumulativeSum) + 1;
                System.out.println("Subarray found from index " + start + " to " + i);
                count++;
            }

            // Store the current cumulative sum and its index
            map.put(cumulativeSum, i);
        }

        return count; // Return the count of zero-sum subarrays found
    }

    public static void main(String[] args) {
        // Create an array
        int[] arr = {6, -3, 2, -3, 4, 1, -1, 2, 3, -2, -3};
        // Instance of the class
        SubarraysWithZeroSum obj = new SubarraysWithZeroSum();
        // Find and print the zero sum subarray
        int result = obj.findZeroSumSubarrays(arr);
        System.out.println("Number of subarrays with zero sum: " + result);
    }
}
