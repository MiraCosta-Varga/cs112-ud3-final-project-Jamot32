package cs112.ud3.models;


import java.time.LocalDateTime;

public class Booking {
    private User user;           // The user who makes the booking
    private Movie movie;         // The movie being booked
    private int seatsBooked;     // Number of seats booked
    private LocalDateTime bookingDate;  // Date and time when the booking was made

    // Constructor
    public Booking(User user, Movie movie, int seatsBooked) {
        if (user == null || movie == null) {
            throw new IllegalArgumentException("User and Movie cannot be null.");
        }
        if (seatsBooked <= 0) {
            throw new IllegalArgumentException("Number of seats booked must be greater than zero.");
        }

        this.user = user;
        this.movie = movie;
        this.seatsBooked = seatsBooked;
        this.bookingDate = LocalDateTime.now(); // Set the current date and time
    }

    // Getter methods
    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    // Booking details
    public String getBookingDetails() {
        return "Booking Details: \n" +
                "User: " + user.getUsername() + "\n" +
                "Movie: " + movie.getTitle() + "\n" +
                "Seats Booked: " + seatsBooked + "\n" +
                "Booking Date: " + bookingDate;
    }

    // Cancel the booking (also updates the available seats in the movie)
    public void cancelBooking() {
        movie.freeSeats(seatsBooked); // Free up the booked seats in the movie
        System.out.println("Booking canceled: " + getBookingDetails());
    }

    @Override
    public String toString() {
        return getBookingDetails();
    }
}
