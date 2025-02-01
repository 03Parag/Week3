package Week3.Day02;

import java.util.Stack;

// SortStackRecursively class
class SortStackRecursively {

    // Method to insert an element in a sorted stack
    public void insertInSortedOrder(Stack<Integer> stack, int value) {
        // If stack is empty or stack's value same or less then  value
        if (stack.isEmpty() || stack.peek() <= value) {
            // Place value in the correct position
            stack.push(value);
            return;
        }

        // Pop the element from the stack and store in temp
        int temp = stack.pop();
        // Recursively insert value
        insertInSortedOrder(stack, value);
        //Push the element in the stack
        stack.push(temp);
    }
    // Method to sort the stack using recursion
    public void sortStack(Stack<Integer> stack) {
        // if the stack is not empty
        if (!stack.isEmpty()) {
            // Pop the element and store in top
            int top = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the popped element at the right position
            insertInSortedOrder(stack, top);
        }
    }


    public static void main(String[] args) {
        // Create an instance of the class
        SortStackRecursively sorter = new SortStackRecursively();
        // Create an empty stack
        Stack<Integer> stack = new Stack<>();
        // Push the 3 elements
        stack.push(1);
        stack.push(3);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        // Sort the stack
        sorter.sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
