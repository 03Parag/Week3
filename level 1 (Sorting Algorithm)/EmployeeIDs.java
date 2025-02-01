package Week3.Day03;

import java.util.Arrays;
// EmployeeIDs class
class EmployeeIDs {
    // Method to perform Insertion Sort
    public static void insertionSort(int[] employeeIDs) {
        // Store the length of the employeeIDs array
        int n = employeeIDs.length;

        // Loop through the second element to the last element
        for (int i = 1; i < n; i++) {
            // Pick the element to insert
            int key = employeeIDs[i];
            int j = i - 1;

            // Move elements of the sorted part that are greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            // Insert the key at its correct position
            employeeIDs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Create an array of employee IDs
        int[] employeeIDs = {105, 102, 110, 101, 108, 103};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(employeeIDs));

        // Sorting the employee IDs using Insertion Sort
        insertionSort(employeeIDs);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(employeeIDs));
    }
}

