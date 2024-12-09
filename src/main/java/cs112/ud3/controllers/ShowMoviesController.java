package cs112.ud3.controllers;

import cs112.ud3.Main;
import cs112.ud3.models.Movie;
import cs112.ud3.models.MovieManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import java.io.IOException;

public class ShowMoviesController {

    @FXML
    private ListView<Movie> moviesListView;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        // Load movies into the ListView
        ObservableList<Movie> movieList = MovieManager.getInstance().getMovieList();
        moviesListView.setItems(movieList);
    }

    @FXML
    private void onBackButtonClicked(ActionEvent event) {
        try {
            Main.loadView("logInMenu-view.fxml", 400, 600);  // Load the login view
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to go back to login view.");
        }
    }
}
