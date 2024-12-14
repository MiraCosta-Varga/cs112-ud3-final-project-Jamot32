package cs112.ud3.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class MovieManager {
    private static MovieManager instance;
    private ObservableList<Movie> movieList;
    private MovieManager() {
        movieList = FXCollections.observableArrayList();
    }
    public static MovieManager getInstance() {
        if (instance == null) {
            instance = new MovieManager();
        }
        return instance;
    }
    public ObservableList<Movie> getMovieList() {
        return movieList;
    }
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
    public void removeMovie(Movie movie) {
        movieList.remove(movie);
    }
    public void updateMovie(Movie oldMovie, Movie newMovie) {
        int index = movieList.indexOf(oldMovie);
        if (index >= 0) {
            movieList.set(index, newMovie);
        }
    }
}