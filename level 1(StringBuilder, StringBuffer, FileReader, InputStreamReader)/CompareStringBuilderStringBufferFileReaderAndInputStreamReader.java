package Week3.Day04;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
// Create a CompareStringBuilderStringBufferFileReaderAndInputStreamReader class to compare each of their performance based on time taken
class CompareStringBuilderStringBufferFileReaderAndInputStreamReader {

    // Method to count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        // Initialize the word count to 0
        int wordCount = 0;
        // Create a BufferedReader object
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Loop through each line using the readLine() method
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words and count
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the word count
        return wordCount;
    }

    // Method to count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        // Initialize the word count to 0
        int wordCount = 0;
        // Create a BufferedReader object
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            // Loop through each line using the readLine() method
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words and count
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the word count
        return wordCount;
    }

    public static void main(String[] args) {
        // Enter the word to be appended
        String wordToAppend = "hello";
        // Enter the number of iterations
        int iterations = 1_000_000;

        // Measure performance of StringBuilder
        // Start time of StringBuilder
        long startTime = System.nanoTime();
        // Create a StringBuilder object
        StringBuilder stringBuilder = new StringBuilder();
        // Loop through iteration variable and append the string
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(wordToAppend);
        }
        // End time of StringBuilder
        long endTime = System.nanoTime();
        // Duration time of StringBuilder and convert to milliseconds
        long durationTime = (endTime - startTime) / 1_000_000;
        // Print the time taken by StringBuilder
        System.out.println("StringBuilder Time: " + durationTime + " ms");

        // Measure performance of StringBuffer
        // Start time of StringBuffer
        startTime = System.nanoTime();
        // Create a StringBuffer object
        StringBuffer stringBuffer = new StringBuffer();
        // Loop through iteration variable and append the string
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(wordToAppend);
        }
        // End time of StringBuffer
        endTime = System.nanoTime();
        // Duration time of StringBuffer and convert to milliseconds
        durationTime = (endTime - startTime) / 1_000_000;
        // Print the time taken by StringBuffer
        System.out.println("StringBuffer Time: " + durationTime + " ms");

        // Enter the file path for reading
        String filePath = "C:/Users/welcome/Desktop/Training Assessment/output.txt";

        // Measure performance of FileReader
        // Start time of FileReader
        startTime = System.nanoTime();
        // Call the method to count the word using InputStreamReader
        int fileReaderWordCount = countWordsUsingFileReader(filePath);
        // End time of FileReader
        endTime = System.nanoTime();
        // Duration time of FileReader and convert to milliseconds
        durationTime = (endTime - startTime) / 1_000_000;
        // Print the word count and time taken by FileReader
        System.out.println("FileReader Word Count: " + fileReaderWordCount);
        System.out.println("FileReader Time: " + durationTime + " ms");

        // Measure performance of InputStreamReader
        // Start time of InputStreamReader
        startTime = System.nanoTime();
        // Call the method to count the word using InputStreamReader
        int inputStreamReaderWordCount = countWordsUsingInputStreamReader(filePath);
        //End time of InputStreamReader
        endTime = System.nanoTime();
        // Duration time of InputStreamReader and convert to milliseconds
        durationTime = (endTime - startTime) / 1_000_000;
        // Print the word count and time taken by InputStreamReader
        System.out.println("InputStreamReader Word Count: " + inputStreamReaderWordCount);
        System.out.println("InputStreamReader Time: " + durationTime + " ms");
    }


}