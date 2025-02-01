package Week3.Day02;

import java.util.Deque;
import java.util.LinkedList;
// SlidingWindowMaximum class
class SlidingWindowMaximum {
    // Store number in array and k (window size)
    private int[] nums;
    private int k;

    // Constructor to initialize the array and window size
    public SlidingWindowMaximum(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }

    // Method to find the maximum in each sliding window of size k
    public int[] maxSlidingWindow() {
        // If the number is null or length of number is 0 or window size is 0 or negative
        if (nums == null || nums.length == 0 || k <= 0) {
            // Return an empty array
            return new int[0];
        }

        // Store the length of number and result
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Deque to store indices
        Deque<Integer> deque = new LinkedList<>();

        // Loop through the numbers
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            // If the deque is not empty and first element of deque is smaller than i-k+1
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            // If the deque is not empty and number of peek last element of deque is smaller or equal than num[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offerLast(i);

            // The first element in the deque is the largest element for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create the array and window size
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Create an instance of class
        SlidingWindowMaximum solution = new SlidingWindowMaximum(nums, k);

        // Result of the sliding window maximum
        int[] result = solution.maxSlidingWindow();

        // Print the results
        System.out.print("Sliding Window Maximum: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

