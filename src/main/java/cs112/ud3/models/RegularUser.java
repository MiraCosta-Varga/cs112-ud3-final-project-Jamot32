package cs112.ud3.models;

public class RegularUser extends User {
    // Constructor for RegularUser
    public RegularUser(String username, String password) {
        super(username, password);
    }

    // Book tickets for a movie
    @Override
    public void bookTicket(Movie movie, int seats) throws MovieNotAvailableException {
        if (canBook()) {
            movie.updateAvailableSeats(seats);
            currentBookings += seats;
            System.out.println("Successfully booked " + seats + " tickets for movie: " + movie.getTitle());
        } else {
            System.out.println("Cannot book more than " + maxBookings + " tickets.");
        }
    }

    // Cancel tickets for a movie
    @Override
    public void cancelBooking(Movie movie, int seats) {
        if (seats <= currentBookings) {
            movie.freeSeats(seats);
            currentBookings -= seats;
            System.out.println("Successfully canceled " + seats + " tickets for movie: " + movie.getTitle());
        } else {
            System.out.println("You do not have enough tickets to cancel.");
        }
    }
}
