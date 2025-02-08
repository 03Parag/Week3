package Week3.Day05;
// Create PeakElementFinder class to find the peak of an element
class PeakElementFinder {
    // Method to find a peak element
    public static int findPeakElement(int[] arr) {
        // Initialize left to 0
        int left = 0;
        int right = arr.length - 1;

        // If left is lesser than right
        while (left < right) {
            // Find the mid
            int mid = left + (right - left) / 2;

            // Check if mid is greater than both neighbors (mid is a peak)
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If mid is less than its previous element, search in the left half
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else search in the right half
            else {
                left = mid + 1;
            }
        }

        // The left index point to a peak element
        return left;
    }

    public static void main(String[] args) {
        // Create an element array
        int[] element = {1, 3, 20, 4, 1, 0};

        // Call the method to find a peak element
        int peakIndex = findPeakElement(element);

        // Print the peak element index and value
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + element[peakIndex]);
    }
}

