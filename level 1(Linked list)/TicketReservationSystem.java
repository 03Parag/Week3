package Week3.Day01;

// TicketReservationSystem class
class TicketReservationSystem {

    // Node representing a booked ticket
    class Ticket {
        // Attributes for ticket node
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        // Points to the next ticket in the circular list
        Ticket next;

        // Constructor for a ticket node
        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            // This will be updated when linking in the circular list
            this.next = null;
        }
    }

    // Circular Linked List class to manage the ticket reservations
    class TicketList {
        // Head and Tail pointers for the circular linked list
        private Ticket head = null;
        private Ticket tail = null;

        // Add a new reservation at the end of the circular list
        public void addReservation(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

            if (head == null) {
                head = newTicket;
                tail = newTicket;
                // Point to itself (circular)
                newTicket.next = head;
            } else {
                // Last node points to new ticket
                tail.next = newTicket;
                // Update tail to new ticket
                tail = newTicket;
                // Circular link: tail points back to head
                tail.next = head;
            }
            System.out.println("Ticket reserved: " + customerName + " for " + movieName);
        }

        // Remove a reservation by Ticket ID
        public void removeReservation(int ticketId) {
            if (head == null) {
                System.out.println("No tickets to remove.");
                return;
            }

            Ticket current = head;
            Ticket prev = null;

            // Handle the case where the head is to be deleted
            if (current.ticketId == ticketId) {
                // Only one node in the list
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                    tail.next = head;
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }

            // Traverse the list to find the ticket to remove
            while (current.next != head && current.ticketId != ticketId) {
                prev = current;
                current = current.next;
            }

            if (current.ticketId == ticketId) {
                prev.next = current.next;
                if (current == tail) {
                    // Update tail if last node is removed
                    tail = prev;
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
            } else {
                System.out.println("Ticket with ID " + ticketId + " not found.");
            }
        }

        // Display all ticket reservations in the list
        public void displayTickets() {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }

            Ticket current = head;
            do {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                current = current.next;
            } while (current != head);
        }

        // Search for a ticket by Customer Name or Movie Name
        public void searchTicket(String searchTerm) {
            if (head == null) {
                System.out.println("No tickets available to search.");
                return;
            }

            Ticket current = head;
            boolean found = false;
            do {
                if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                    System.out.println("Ticket found - Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                    found = true;
                }
                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No ticket found matching the search term.");
            }
        }

        // Calculate total number of booked tickets
        public void totalTickets() {
            if (head == null) {
                System.out.println("No tickets booked.");
                return;
            }

            int count = 0;
            Ticket current = head;
            do {
                count++;
                current = current.next;
            } while (current != head);

            System.out.println("Total number of booked tickets: " + count);
        }
    }

    public static void main(String[] args) {
        // Create an instance of TicketList inside main method
        TicketReservationSystem system = new TicketReservationSystem();
        TicketList ticketList = system.new TicketList();

        // Add reservations
        ticketList.addReservation(101, "Alice", "The Avengers", "A1", "2025-01-28 14:00");
        ticketList.addReservation(102, "Bob", "Spider-Man", "B2", "2025-01-28 15:00");
        ticketList.addReservation(103, "Charlie", "Iron Man", "C3", "2025-01-28 16:00");

        // Display all reservations
        System.out.println("\nCurrent reservations:");
        ticketList.displayTickets();

        // Search for a ticket by Customer Name
        System.out.println("\nSearch result for 'Bob':");
        ticketList.searchTicket("Bob");

        // Remove a reservation
        ticketList.removeReservation(102);

        // Display all reservations after removal
        System.out.println("\nReservations after removal of Ticket ID 102:");
        ticketList.displayTickets();

        // Calculate the total number of tickets
        ticketList.totalTickets();
    }
}
