package Week3.Day05;
// Create SearchWordInSentences class to search the word from a list of sentences
class SearchWordInSentences {
    // Method to find the sentence with word
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Loop through the length of sentence array
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            // Check if sentence contains the word
            if (sentence.contains(word)) {
                // Return the first matching sentence
                return sentence;
            }
        }
        // Return if no sentence contains the word
        return "Not Found";
    }

    public static void main(String[] args) {
        // Create an array of sentences
        String[] sentences = { "Java is a powerful programming language.", "Linear search is a simple searching algorithm.", "Data structures are essential for coding." };
        // Create the word to be searched
        String wordToSearch = "Java";

        // Call the method to find the sentence with word
        String result = findSentenceWithWord(sentences, wordToSearch);

        // Print the result
        System.out.println("Sentence containing '" + wordToSearch + "': " + result);
    }
}

