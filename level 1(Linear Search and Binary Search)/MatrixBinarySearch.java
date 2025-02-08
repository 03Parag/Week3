package Week3.Day05;
// Create a MatrixBinarySearch class to search the target value
class MatrixBinarySearch {
    // Method to search for a target value in a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Initialize lef tot 0 and store length of matrix array in row
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = rows * columns - 1;

        // If left is lesser than right
        while (left < right) {
            // Find the mid
            int mid = left + (right - left) / 2;

            // Convert 1D mid index to 2D row and column
            int row = mid / columns;
            int col = mid % columns;
            int midValue = matrix[row][col];

            // Check if we found the target
            if (midValue == target) {
                return true;
            }
            // If target is smaller, search left half
            else if (target < midValue) {
                right = mid - 1;
            }
            // If target is larger, search right half
            else {
                left = mid + 1;
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {
        // Create an array of matrix
        int[][] matrix = { {1, 3, 5}, {7, 10, 11}, {13, 15, 18} };
        // Enter the target
        int target = 10;

        // Call the method to search for a target value in a 2D matrix and print the result
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }
}

