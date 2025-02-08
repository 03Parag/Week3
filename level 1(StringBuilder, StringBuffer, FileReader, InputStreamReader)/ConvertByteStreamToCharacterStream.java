package Week3.Day04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

// Create a ConvertByteStreamToCharacterStream class to convert the byte stream into a character stream and print character
class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/Week3/Day04/ConvertByteStreamToCharacterStream.java";

        // Create a BufferedReader object
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;

            // Read the file line by line and print each line to the console
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}

