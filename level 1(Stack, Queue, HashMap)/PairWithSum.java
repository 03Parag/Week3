package Week3.Day02;

import java.util.HashMap;

// PairWithSum class
class PairWithSum {

    // Method to check if a pair exists with the given sum
    public boolean hasPairWithSum(int[] arr, int target) {
        // HashMap to store visited numbers
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Calculate required complement
            int needed = target - num;

            // Check if the needed value exists in the map
            if (map.containsKey(needed)) {
                System.out.println("Pair found: (" + needed + ", " + num + ")");
                return true;
            }

            // Store the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // No pair found
        System.out.println("No pair found with sum " + target);
        return false;
    }

    public static void main(String[] args) {
        // Create an array and target
        int[] arr = {10, 15, 3, 7, 8, 5};
        int target = 18;

        // Create an instance  of the class
        PairWithSum obj = new PairWithSum();
        // Check for a pair
        boolean result = obj.hasPairWithSum(arr, target);
        System.out.println("Number of pair with sum " + result);
    }
}
