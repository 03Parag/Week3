package Week3.Day01;

// MovieManagementSystem class
class MovieManagementSystem {
    // Node class representing a movie record
    class Movie {
        // Attributes for movie node
        String title;
        String director;
        int yearOfRelease;
        double rating;
        Movie next, prev;

        // Constructor for a movie node
        public Movie(String title, String director, int yearOfRelease, double rating) {
            this.title = title;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and Tail pointers for the doubly linked list
    private Movie head = null;
    private Movie tail = null;

    // Add a movie record at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at the beginning: " + title);
    }

    // Add a movie record at the end of the list
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at the end: " + title);
    }

    // Add a movie record at a specific position
    public void addMovieAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addMovieAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            if (current.next != null) {
                current.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            current.next = newMovie;
            newMovie.prev = current;
            System.out.println("Movie added at position " + position + ": " + title);
        }
    }

    // Remove a movie record by Movie Title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie with title '" + title + "' not found.");
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
        System.out.println("Movie with title '" + title + "' removed.");
    }

    // Search for a movie by Director or Rating
    public void searchMovie(String director, Double rating) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                    (rating != null && current.rating == rating)) {
                System.out.println("Movie Found: Title: " + current.title + ", Director: " + current.director + ", Year of Release: " + current.yearOfRelease + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movie found with the given details.");
        }
    }

    // Update a movie's rating based on its title
    public void updateMovieRating(String title, double newRating) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie '" + title + "': " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title '" + title + "' not found.");
    }

    // Display all movie records in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in forward order:");
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year of Release: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in reverse order:");
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year of Release: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Count the total number of movies
    public void countMovies() {
        int count = 0;
        Movie current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of movies in the list: " + count);
    }

    public static void main(String[] args) {
        MovieManagementSystem movieSystem = new MovieManagementSystem();

        // Add movies
        movieSystem.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieSystem.addMovieAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieSystem.addMovieAtPosition("The Matrix", "Wachowski", 1999, 8.7, 2);

        // Display movies
        System.out.println();
        movieSystem.displayMoviesForward();

        // Search for a movie
        System.out.println();
        movieSystem.searchMovie("Wachowski", null);

        // Update a movie's rating
        System.out.println();
        movieSystem.updateMovieRating("Inception", 9.1);

        // Display movies in reverse
        System.out.println();
        movieSystem.displayMoviesReverse();

        // Remove a movie
        System.out.println();
        movieSystem.removeMovieByTitle("The Dark Knight");

        // Display movies and count
        System.out.println();
        movieSystem.displayMoviesForward();
        movieSystem.countMovies();
    }
}


