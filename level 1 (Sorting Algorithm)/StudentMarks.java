package Week3.Day03;

import java.util.Arrays;
// StudentMarks class
class StudentMarks {
    // Method to perform Bubble Sort
    public static void bubbleSort(int[] marks) {
        // Store the length of the marks array and swapped variable of boolean datatype
        int n = marks.length;
        boolean swap;

        // Loop through the array
        for (int i = 0; i < n - 1; i++) {
            swap = false;

            // Loop through the marks length
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if needed
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swap = true;
                }
            }

            // If no swaps occurred, the array is already sorted
            if (!swap)
                break;
        }
    }

    public static void main(String[] args) {
        // Create an array for student marks
        int[] studentMarks = {85, 72, 96, 60, 45, 88, 90};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(studentMarks));

        // Sorting the marks using Bubble Sort
        bubbleSort(studentMarks);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(studentMarks));
    }
}
