package Week3.Day04;

// Create a ConcatenateStrings class to concatenate a strings using a StringBuffer
class ConcatenateStrings {
    public static void main(String[] args) {
        // Given array of strings
        String[] words = {"Hello", " everyone", "!", " Welcome", " to", " the",  " coding", " life."};

        // Print the original strings
        System.out.print("Original Strings: ");
        // Loop through the length of words array
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            // Adding a separator for clarity
            if (i < words.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Create a StringBuffer object
        StringBuffer concatenatedString = new StringBuffer();

        // Append each string to StringBuffer
        for (int i = 0; i < words.length; i++) {
            concatenatedString.append(words[i]);
        }

        // Convert StringBuffer to string
        String result = concatenatedString.toString();

        // Print the concatenated string
        System.out.println("Concatenated String: " + result);
    }
}
