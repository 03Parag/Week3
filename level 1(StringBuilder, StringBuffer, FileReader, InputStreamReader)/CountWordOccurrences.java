package Week3.Day04;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

// Create a CountWordOccurrences class to count occurrences of a word in a file
class CountWordOccurrences {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/Week3/Day04/CountWordOccurrences.java";
        // Enter the word to be counted
        String targetWord = "String";
        // Initialize the word count to 0
        int wordCount = 0;

        // Create a BufferedReader object
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Loop through each line using the readLine() method
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words based on spaces and punctuation
                String[] words = line.split("\\W+");

                // Loop through the length of the word
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(targetWord)) {
                        // Increment the word count
                        wordCount++;
                    }
                }
            }

            // Print the final count
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}
