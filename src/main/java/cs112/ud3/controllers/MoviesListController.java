package cs112.ud3.controllers;
import cs112.ud3.models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class MoviesListController {
    @FXML
    private ListView<Movie> moviesListView;
    private ObservableList<Movie> movieList;
    @FXML
    private void initialize() {
        movieList = FXCollections.observableArrayList();
        moviesListView.setItems(movieList);
    }
    public void setMovies(ObservableList<Movie> movies) {
        this.movieList.setAll(movies);
    }
}
