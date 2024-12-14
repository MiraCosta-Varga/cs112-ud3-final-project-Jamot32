package cs112.ud3.models;
public class AdminUser extends User {
    // Constructor for AdminUser
    public AdminUser(String username, String password) {
        super(username, password);
        this.maxBookings = Integer.MAX_VALUE;
    }
    // Book tickets for a movie (same as regular user, but admins can book unlimited)
    @Override
    public void bookTicket(Movie movie, int seats) throws MovieNotAvailableException {
        movie.updateAvailableSeats(seats);
        currentBookings += seats;
        System.out.println("Admin successfully booked " + seats + " tickets for movie: " + movie.getTitle());
    }
    // Cancel tickets for a movie
    @Override
    public void cancelBooking(Movie movie, int seats) {
        if (seats <= currentBookings) {
            movie.freeSeats(seats);
            currentBookings -= seats;
            System.out.println("Admin successfully canceled " + seats + " tickets for movie: " + movie.getTitle());
        } else {
            System.out.println("Admin cannot cancel more tickets than are booked.");
        }
    }
    // Admin can add or update movie details
    public void updateMovieDetails(Movie movie, String newTitle, String newDirector, String newGenre, int newAvailableSeats) {
        movie.updateMovieDetails(newTitle, newDirector, newGenre, newAvailableSeats);
        System.out.println("Admin updated movie details: " + movie.getDetails());
    }
    // Admin can remove a movie
    public void removeMovie(Movie movie) {
        System.out.println("Admin has removed the movie: " + movie.getTitle());
    }
}