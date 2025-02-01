package Week3.Day02;

import java.util.HashMap;

// TwoSum class
class TwoSum {
    // Method to find two indices that sum up to the target
    public int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Loop through the length of number
        for (int i = 0; i < nums.length; i++) {
            // Value needed to reach target
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                // Return indices
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        // Return [-1, -1] if no solution exist
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Instance of the class
        TwoSum twoSum = new TwoSum();
        // Create an array for number and enter a value for target
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // Find and print the result
        int[] result = twoSum.findTwoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

