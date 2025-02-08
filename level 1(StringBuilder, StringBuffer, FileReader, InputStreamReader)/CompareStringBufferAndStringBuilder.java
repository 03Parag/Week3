package Week3.Day04;

// Create a CompareStringBufferAndStringBuilder class to compare StringBuffer and StringBuilder using concatenation
class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        // Enter the number of iterations (1 million)
        int iterations = 1000000;
        // Enter the word to be appended 1 million times
        String wordToAppend = "hello";

        // Measure time for StringBuffer
        long startTimeStringBuffer = System.nanoTime();

        // Create a StringBuffer object
        StringBuffer stringBufferConcatenation = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBufferConcatenation.append(wordToAppend);
        }
        long endTimeStringBuffer = System.nanoTime();
        long durationStringBuffer = endTimeStringBuffer - startTimeStringBuffer;

        // Measure time for StringBuilder
        long startTimeStringBuilder = System.nanoTime();
        // Create a StringBuilder object
        StringBuilder stringBuilderConcatenation = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilderConcatenation.append(wordToAppend);
        }
        long endTimeStringBuilder = System.nanoTime();
        long durationStringBuilder = endTimeStringBuilder - startTimeStringBuilder;

        // Print the results
        System.out.println("Time taken by StringBuffer for " + iterations + " concatenations: " + durationStringBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder for " + iterations + " concatenations: " + durationStringBuilder + " nanoseconds");
    }
}

