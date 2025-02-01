package Week3.Day01;

// LibraryManagementSystem class
class LibraryManagementSystem {
    // Node class representing a book
    class Book {
        // Attributes for Book node
        String title, author, genre;
        int bookId;
        boolean isAvailable;
        Book next, prev;

        // Constructor for a book node
        public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and Tail pointers for the doubly linked list
    private Book head = null;
    private Book tail = null;

    // Add a book at the beginning of the list
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at the beginning: " + title);
    }

    // Add a book at the end of the list
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at the end: " + title);
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = current.next;
            if (current.next != null) {
                current.next.prev = newBook;
            } else {
                tail = newBook;
            }
            current.next = newBook;
            newBook.prev = current;
            System.out.println("Book added at position " + position + ": " + title);
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book current = head;
        boolean found = false;
        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) ||
                    (author != null && current.author.equalsIgnoreCase(author))) {
                System.out.println("Book Found: Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + (current.isAvailable ? "Available" : "Not Available"));
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No book found with the given details.");
        }
    }

    // Update availability status of a book
    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Book availability updated for ID " + bookId + ": " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in forward order:");
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    // Display books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in reverse order:");
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    // Count the total number of books
    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Add books
        library.addBookAtEnd("The White Tiger", "Aravind Adiga", "Fiction", 201, true);
        library.addBookAtBeginning("God of Small Things", "Arundhati Roy", "Novel", 202, false);
        library.addBookAtPosition("Wings of Fire", "Dr. A.P.J. Abdul Kalam", "Autobiography", 203, true, 2);

        // Display books
        System.out.println();
        library.displayBooksForward();

        // Search for a book
        System.out.println();
        library.searchBook("Wings of Fire", null);

        // Update availability
        System.out.println();
        library.updateAvailabilityStatus(203, false);

        // Display books in reverse
        System.out.println();
        library.displayBooksReverse();

        // Remove a book
        System.out.println();
        library.removeBookById(202);

        // Display books and count
        System.out.println();
        library.displayBooksForward();
        library.countBooks();
    }
}


