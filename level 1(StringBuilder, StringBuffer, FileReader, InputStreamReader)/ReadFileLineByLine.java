package Week3.Day04;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

// Create a ReadFileLineByLine class to read a file line by line
class ReadFileLineByLine {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/Week3/Day04/ReadFileLineByLine.java";

        // Create a BufferedReader object
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Loop through each line using the readLine() method
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line
                System.out.println(line);
            }
        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}
