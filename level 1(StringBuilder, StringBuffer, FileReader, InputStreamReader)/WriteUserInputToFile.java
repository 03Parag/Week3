package Week3.Day04;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

// Create a WriteUserInputToFile class to read user input and write it to a file
class WriteUserInputToFile {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/Week3/Day04/WriteUserInputToFile.java";

        // Print instructions for the user
        System.out.println("Enter text to write to the file and type 'exit' to stop:");

        // Create BufferedReader object
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             // Create FileWriter object
             FileWriter fileWriter = new FileWriter(filePath)) {

            // Read the first input
            String userInput = consoleReader.readLine();

            // Loop through the user input till we do not receive "exit"
            while (!userInput.equalsIgnoreCase("exit")) {
                // Write the user input to the file and add a new line
                fileWriter.write(userInput + System.lineSeparator());

                // Read the next input
                userInput = consoleReader.readLine();
            }

            System.out.println("User input is written successfully in  the file: " + filePath);

        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}

