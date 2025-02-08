package Week3.Day04;
import java.util.HashSet;

// Create a RemoveDuplicates class to remove the duplicate characters from the string using StringBuilder
class RemoveDuplicates {
    public static void main(String[] args) {
        // Create an string
        String word = "hello";

        // Print the original string
        System.out.println("Original String: " + word);

        // Create a StringBuilder object
        StringBuilder uniqueString = new StringBuilder();

        // Create a HashSet to track characters
        HashSet<Character> seenCharacters = new HashSet<>();

        // Loop through each character in the string
        for (int i = 0; i < word.length(); i++) {
            // Get the character at index i
            char ch = word.charAt(i);
            // If character is not already added, append it and add to HashSet
            if (!seenCharacters.contains(ch)) {
                uniqueString.append(ch);
                seenCharacters.add(ch);
            }
        }

        // Convert StringBuilder to string
        String result = uniqueString.toString();

        // Print the string after duplicates are removed
        System.out.println("String after Removing Duplicates: " + result);
    }
}

