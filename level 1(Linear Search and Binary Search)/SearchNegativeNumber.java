package Week3.Day05;
// Create a SearchNegativeNumber class to find the first negative number
class SearchNegativeNumber {
    // Method to find the first negative number
    public static int findFirstNegative(int[] arr) {
        // Loop through the length of array
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is negative
            if (arr[i] < 0) {
                // Return the index of the first negative number
                return i;
            }
        }
        // Return -1 if no negative number is found
        return -1;
    }

    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = {3, 5, 7, -2, 8, -6};
        // Call the method to find the first negative number
        int result = findFirstNegative(numbers);

        // Check if result is not-1 then the negative number is present else not and print the result
        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}

