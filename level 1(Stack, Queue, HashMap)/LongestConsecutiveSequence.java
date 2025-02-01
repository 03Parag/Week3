package Week3.Day02;

import java.util.HashMap;

// LongestConsecutiveSequence class
class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive sequence
    public int longestConsecutive(int[] arr) {
        // If the array is empty
        if (arr.length == 0)
            return 0;

        // Store all elements in a HashMap
        HashMap<Integer, Boolean> map = new HashMap<>();
        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Insert a num and true pair (key value pair)
            map.put(num, true);
        }

        // Initialize the maxLength
        int maxLength = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Start a new sequence if num - 1 is not present
            if (!map.containsKey(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Expand the sequence
                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update the maximum length found
                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Create an array
        int[] arr = {100, 4, 200, 1, 3, 2, 5};

        // Create an instance of the class
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        // Find and print the longest consecutive sequence length
        int result = obj.longestConsecutive(arr);
        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}

