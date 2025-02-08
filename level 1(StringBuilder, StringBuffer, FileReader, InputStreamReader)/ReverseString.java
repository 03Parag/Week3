package Week3.Day04;

// Create a ReverseString class to reverse the string using StringBuilder
class ReverseString {
    public static void main(String[] args) {
        // Input string
        String input = "hello";

        // Print the original string
        System.out.println("Original String: " + input);

        // Create a StringBuilder object
        StringBuilder reversedString = new StringBuilder(input);

        // Reverse the string
        reversedString.reverse();

        // Convert StringBuilder to a string
        String result = reversedString.toString();

        // Print the reversed string
        System.out.println("Reversed String: " + result);

    }
}
