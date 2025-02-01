package Week3.Day01;

// RoundRobinScheduling class
class RoundRobinScheduling {
    // Node class representing a process
    class Process {
        // Attributes for process node
        int processId;
        int burstTime;
        int priority;
        int remainingTime;
        Process next, prev;

        // Constructor for a process node
        public Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            // Initial remaining time is the burst time
            this.remainingTime = burstTime;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and Tail pointers for the circular linked list
    private Process head = null;
    private Process tail = null;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            head.next = head.prev = head;
        } else {
            tail.next = newProcess;
            newProcess.prev = tail;
            newProcess.next = head;
            head.prev = newProcess;
            tail = newProcess;
        }
        System.out.println("Process added: ID " + processId + ", Burst Time: " + burstTime + ", Priority: " + priority);
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }
        Process current = head;
        do {
            if (current.processId == processId) {
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
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;

        Process current = head;

        while (completedProcesses < getProcessCount()) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;

                // Calculate waiting and turnaround time only after process is completed
                if (current.remainingTime == 0) {
                    completedProcesses++;
                    int waitingTime = totalTurnaroundTime - current.burstTime;
                    int turnaroundTime = waitingTime + current.burstTime;

                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;

                    System.out.println("Process ID: " + current.processId + " completed. Waiting Time: " + waitingTime + ", Turnaround Time: " + turnaroundTime);
                }

                // Move to the next process in the circular list
                current = current.next;
            }
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / getProcessCount()));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / getProcessCount()));
    }

    // Get the total count of processes in the circular list
    private int getProcessCount() {
        int count = 0;
        if (head != null) {
            Process current = head;
            do {
                count++;
                current = current.next;
            } while (current != head);
        }
        return count;
    }

    // Display all processes in the circular list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }
        Process current = head;
        System.out.println("List of Processes:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority + ", Remaining Time: " + current.remainingTime);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduling scheduler = new RoundRobinScheduling();

        // Add processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 4);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round robin scheduling with a time quantum of 4 units
        System.out.println("\nStarting Round Robin Scheduling with Time Quantum = 4");
        scheduler.roundRobinScheduling(4);

        // Display final list of processes
        System.out.println("\nFinal List of Processes:");
        scheduler.displayProcesses();
    }
}
