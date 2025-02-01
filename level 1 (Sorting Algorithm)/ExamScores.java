package Week3.Day03;

import java.util.Arrays;
// ExamScores class
class ExamScores {
    // Method to perform Selection Sort
    public static void selectionSort(int[] scores) {
        // Store the length of the scores array
        int n = scores.length;

        // Loop through the scores array
        for (int i = 0; i < n - 1; i++) {
            // Assume the first unsorted element is the minimum
            int minIndex = i;

            // Find the index of the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                // If the score of j is less than minimum index
                if (scores[j] < scores[minIndex]) {
                    // Update minIndex if a smaller element is found
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            swap(scores, i, minIndex);
        }
    }

    // Method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Create an array of exam scores
        int[] examScores = {85, 72, 96, 60, 45, 88, 90};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(examScores));

        // Sorting the exam scores using Selection Sort
        selectionSort(examScores);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(examScores));
    }
}

