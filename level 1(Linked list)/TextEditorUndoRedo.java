package Week3.Day01;

// TextEditorUndoRedo class
class TextEditorUndoRedo {

    // Doubly Linked List Node to store the text state
    static class TextState {
        // Attributes for text state node
        String text;
        TextState prev;
        TextState next;

        // Constructor for a text state node
        public TextState(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List class to manage the undo/redo states
    static class UndoRedoHistory {
        // Attributes for undo redo history node
        private TextState head;
        private TextState tail;
        private TextState currentState;
        private int size;
        private final int MAX_HISTORY_SIZE;

        // Constructor for an undo redo history node
        public UndoRedoHistory(int maxHistorySize) {
            this.head = null;
            this.tail = null;
            this.currentState = null;
            this.size = 0;
            this.MAX_HISTORY_SIZE = maxHistorySize;
        }

        // Add a new text state to the history (end of the list)
        public void addState(String text) {
            TextState newState = new TextState(text);
            if (size == 0) {
                head = newState;
                tail = newState;
                currentState = newState;
            } else {
                // Check if history size exceeds the limit
                if (size == MAX_HISTORY_SIZE) {
                    // Remove the oldest state (head)
                    head = head.next;
                    head.prev = null;
                } else {
                    size++;
                }
                // Add new state at the end
                tail.next = newState;
                newState.prev = tail;
                tail = newState;
                currentState = tail;
            }
        }

        // Undo the last action (move back in history)
        public String undo() {
            if (currentState != null && currentState.prev != null) {
                currentState = currentState.prev;
                return currentState.text;
            }
            return "No more history to undo.";
        }

        // Redo the last undone action (move forward in history)
        public String redo() {
            if (currentState != null && currentState.next != null) {
                currentState = currentState.next;
                return currentState.text;
            }
            return "No more history to redo.";
        }

        // Get the current state of the text
        public String getCurrentState() {
            if (currentState != null) {
                return currentState.text;
            }
            return "No text yet.";
        }

        // Display all text states in history (from the first to last)
        public void displayHistory() {
            TextState current = head;
            while (current != null) {
                System.out.println(current.text);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        UndoRedoHistory editorHistory = new UndoRedoHistory(10);

        // Add states to the history
        editorHistory.addState("Hello");
        System.out.println("Current State: " + editorHistory.getCurrentState());

        editorHistory.addState("Hello, World!");
        System.out.println("Current State: " + editorHistory.getCurrentState());

        editorHistory.addState("Hello, World! This is the text editor.");
        System.out.println("Current State: " + editorHistory.getCurrentState());

        // Undo the last action
        System.out.println("Undo: " + editorHistory.undo());

        // Redo the undone action
        System.out.println("Redo: " + editorHistory.redo());

        // Add more states and test the history size limit
        editorHistory.addState("New state 1");
        editorHistory.addState("New state 2");
        editorHistory.addState("New state 3");
        editorHistory.addState("New state 4");
        editorHistory.addState("New state 5");
        editorHistory.addState("New state 6");
        editorHistory.addState("New state 7");
        editorHistory.addState("New state 8");
        editorHistory.addState("New state 9");
        editorHistory.addState("New state 10");
        // This will remove "New state 1"
        editorHistory.addState("New state 11");

        System.out.println("\nHistory after adding 11th state (limit 10 states):");
        editorHistory.displayHistory();

        // Undo and Redo tests after history has been filled up
        System.out.println("\nUndoing once: " + editorHistory.undo());
        System.out.println("Undoing again: " + editorHistory.undo());

        System.out.println("Redoing: " + editorHistory.redo());
        System.out.println("Redoing again: " + editorHistory.redo());
    }
}
