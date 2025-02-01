package Week3.Day02;

import java.util.Stack;

// QueueUsingStacks class
class QueueUsingStacks {
    // Store integer in stack 1 and stack 2
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Initialize stack 1 and stack 2 as empty
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue operation
    public int dequeue() {
        // If the stack is empty throw a runtime exception
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation
    public int peek() {
        // If the stack is empty throw a runtime exception
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        // Create an instance of class
        QueueUsingStacks queue = new QueueUsingStacks();
        // Enqueue the 3 elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Output: 1
        System.out.println(queue.dequeue());
        // Enqueue the element
        queue.enqueue(4);
        // Output: 2
        System.out.println(queue.dequeue());
        // Output: 3
        System.out.println(queue.peek());
        // Output: 3
        System.out.println(queue.dequeue());
        // Output: 4
        System.out.println(queue.dequeue());
    }
}
