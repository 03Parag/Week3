package Week3.Day01;

// TaskScheduler class
class TaskScheduler {
    // Node class representing a task
    static class Task {
        // Attributes for task node
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next, prev;

        // Constructor for a task node
        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and Tail pointers for the circular linked list
    private Task head = null;
    private Task tail = null;

    // Add a task at the beginning of the list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            head.next = head.prev = head;  // Circular link
        } else {
            newTask.next = head;
            newTask.prev = tail;
            head.prev = newTask;
            tail.next = newTask;
            head = newTask;
        }
        System.out.println("Task added at the beginning: " + taskName);
    }

    // Add a task at the end of the list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            head.next = head.prev = head;  // Circular link
        } else {
            tail.next = newTask;
            newTask.prev = tail;
            newTask.next = head;
            head.prev = newTask;
            tail = newTask;
        }
        System.out.println("Task added at the end: " + taskName);
    }

    // Add a task at a specific position in the list
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
            if (current == head)
                // Prevent infinite loop in circular list
                break;
        }
        if (current == null || current == head) {
            System.out.println("Position out of bounds. Adding at the end.");
            addTaskAtEnd(taskId, taskName, priority, dueDate);
        } else {
            newTask.next = current.next;
            newTask.prev = current;
            current.next.prev = newTask;
            current.next = newTask;
            System.out.println("Task added at position " + position + ": " + taskName);
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task current = head;
        do {
            if (current.taskId == taskId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.prev = tail;
                    tail.next = head;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = head;
                    head.prev = tail;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task in the circular list
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current Task: " + head.taskName);
        head = head.next; // Move to the next task
    }

    // Display all tasks in the list starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task current = head;
        System.out.println("All tasks in the list:");
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task Found: Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No task found with the given priority.");
        }
    }

    // Count the total number of tasks
    public void countTasks() {
        int count = 0;
        if (head != null) {
            Task current = head;
            do {
                count++;
                current = current.next;
            } while (current != head);
        }
        System.out.println("Total number of tasks in the scheduler: " + count);
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();

        // Add tasks
        taskScheduler.addTaskAtEnd(1, "Complete Homework", 1, "2025-02-01");
        taskScheduler.addTaskAtBeginning(2, "Attend Meeting", 2, "2025-01-30");
        taskScheduler.addTaskAtPosition(3, "Write Report", 3, "2025-02-05", 2);

        // Display tasks
        System.out.println();
        taskScheduler.displayTasks();

        // View current task
        System.out.println();
        taskScheduler.viewCurrentTask();

        // Search for a task by Priority
        System.out.println();
        taskScheduler.searchTaskByPriority(2);

        // Remove a task by ID
        System.out.println();
        taskScheduler.removeTaskById(2);

        // Display tasks and count
        System.out.println();
        taskScheduler.displayTasks();
        taskScheduler.countTasks();
    }
}


