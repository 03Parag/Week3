package Week3.Day02;

import java.util.Queue;
import java.util.LinkedList;
// CircularTour class
class CircularTour {
    // Array to store petrol and distance and the number of petrol pumps
    private int[] petrol;
    private int[] distance;
    private int n;

    // Constructor to initialize petrol, distance, and number of petrol pumps
    public CircularTour(int[] petrol, int[] distance) {
        this.petrol = petrol;
        this.distance = distance;
        this.n = petrol.length;
    }

    // Method to find the starting petrol pump for a complete circular tour
    public int findStartingPump() {
        // Initialize the petrol tour using queue and also totalSurplus, currentSurplus and startIndex
        Queue<Integer> queue = new LinkedList<>();
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;

        // Add all petrol pumps
        // Loop through the petrol pump
        for (int i = 0; i < n; i++) {
            //Enter the element in the queue
            queue.offer(i);
        }

        // Traverse all pumps to find a valid starting point
        // Check if the queue is empty
        while (!queue.isEmpty()) {
            // Remove the current pump index
            int currentPump = queue.poll();

            // Calculate surplus for the current pump
            int fuelBalance = petrol[currentPump] - distance[currentPump];
            // Update current surplus
            currentSurplus += fuelBalance;

            // If currentSurplus is negative, this pump can't be the start point
            // So, move the start index to the next pump
            if (currentSurplus < 0) {
                startIndex = currentPump + 1;
                // Reset the surplus to start from next pump
                currentSurplus = 0;
            }

            // Add the current pump back to the queue
            queue.offer(currentPump);

            // If the complete tour through all petrol pump is done
            // check the totalSurplus
            totalSurplus += fuelBalance;
            // If the number of petrol pump is equal to the size of the queue
            if (queue.size() == n && totalSurplus >= 0) {
                break;
            }
        }

        // If totalSurplus is negative, no valid tour is possible
        if (totalSurplus >= 0) {
            return startIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Create petrol and distance arrays
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        // Create an instance of CircularTour
        CircularTour tour = new CircularTour(petrol, distance);

        // Find and print the starting petrol pump index
        int startPump = tour.findStartingPump();
        if (startPump != -1) {
            System.out.println("The starting petrol pump index is: " + startPump);
        } else {
            System.out.println("No valid starting point exists to complete the circular tour.");
        }
    }
}

