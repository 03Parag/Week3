package Week3.Day02;

import java.util.Stack;
// StockSpan class
class StockSpan {
    // Store integer in stack and store price and span in arrays
    private Stack<Integer> stack;
    private int[] prices;
    private int[] span;

    // Constructor to initialize stack and arrays
    public StockSpan(int[] prices) {
        this.prices = prices;
        this.span = new int[prices.length];
        this.stack = new Stack<>();
    }

    // Method to calculate stock spans
    public void calculateSpan() {
        // Loop through each day's price
        for (int i = 0; i < prices.length; i++) {
            // Pop elements if the current price is less than or equal to stack top
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                stack.pop();
            }

            // Calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            // Push current index onto the stack
            stack.push(i);
        }
    }

    // Method to display the spans
    public void printSpan() {
        System.out.print("Stock Spans: ");
        // Loop through span
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create an array of price
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Create an instance of StockSpan
        StockSpan stockSpan = new StockSpan(prices);

        // Calculate span
        stockSpan.calculateSpan();

        // Print results
        stockSpan.printSpan();
    }
}

