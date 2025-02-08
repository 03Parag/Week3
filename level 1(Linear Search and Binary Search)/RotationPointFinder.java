package Week3.Day05;
// Create RotationPointFinder class  to find the index of the smallest element in the array (the rotation point)
class RotationPointFinder {
    // Method to find the rotation point
    public static int findRotationPoint(int[] arr) {
        // Initialize left to 0
        int left = 0, right = arr.length - 1;

        // If left is lesser than right
        while (left < right) {
            // Find the mid
            int mid = left + (right - left) / 2;

            // If mid-element is greater than the last element, search in right half else search in left half (including mid)
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // The index of the smallest element (rotation point)
        return left;
    }

    public static void main(String[] args) {
        // Create an array of rotated array
        int[] rotatedArray = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        // Call the method to find the rotation point
        int rotationIndex = findRotationPoint(rotatedArray);

        // Print the rotation point index and smallest element
        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + rotatedArray[rotationIndex]);
    }
}
