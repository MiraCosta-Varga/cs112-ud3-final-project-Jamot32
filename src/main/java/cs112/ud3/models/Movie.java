package cs112.ud3.models;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private int seats;
    private int availableSeats;

    public Movie(String title, String director, String genre, int seats) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.seats = seats;
        this.availableSeats = seats;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
        this.availableSeats = seats;  // Reset available seats if total seats change
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void updateAvailableSeats(int seatsBooked) throws MovieNotAvailableException {
        if (availableSeats >= seatsBooked) {
            availableSeats -= seatsBooked;
        } else {
            throw new MovieNotAvailableException("Not enough seats available.");
        }
    }

    public void freeSeats(int seatsCanceled) {
        this.availableSeats += seatsCanceled;
        if (this.availableSeats > this.seats) {
            this.availableSeats = this.seats;
        }
    }

    public void updateMovieDetails(String title, String director, String genre, int seats) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.setSeats(seats);
    }

    public String getDetails() {
        return "Title: " + title + ", Director: " + director + ", Genre: " + genre + ", Available Seats: " + availableSeats;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Genre: " + genre + ", Seats: " + seats;
    }
}
