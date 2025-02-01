package Week3.Day03;

import java.util.Arrays;
// StudentAges class
class StudentAges {
    // Method to perform Counting Sort
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        // Create range of ages (10 to 18 → 9 values), count arrays and output sorted array
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Loop through length of ages to count occurrences of each age
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            // Increment count
            count[age - minAge]++;
        }


        // Loop through range to compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            // Decrement count
            count[ages[i] - minAge]--;
        }

        // Copy sorted values back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        // Create an array of student ages
        int[] studentAges = {12, 15, 11, 18, 14, 10, 16, 12, 17, 13, 15};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(studentAges));

        // Sorting the student ages using Counting Sort
        countingSort(studentAges, 10, 18);

        // Print the array after sorting
        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}

