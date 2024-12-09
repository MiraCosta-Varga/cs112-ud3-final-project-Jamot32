package cs112.ud3.controllers;

import cs112.ud3.Main;
import cs112.ud3.models.Movie;
import cs112.ud3.models.MovieManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminUserController {

    @FXML
    private Button updateMovieButton;

    @FXML
    private Button addMovieButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button goBackToLoginButton;

    @FXML
    private TextField movieTitleField;

    @FXML
    private TextField movieDirectorField;

    @FXML
    private TextField movieGenreField;

    @FXML
    private TextField movieSeatsField;

    @FXML
    private ListView<Movie> movieListView;

    private ObservableList<Movie> movieList;

    @FXML
    private void initialize() {
        movieList = MovieManager.getInstance().getMovieList();
        movieListView.setItems(movieList);
    }

    @FXML
    private void onUpdateMovieButtonClicked(ActionEvent event) {
        Movie selectedMovie = movieListView.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            String newTitle = movieTitleField.getText();
            String newDirector = movieDirectorField.getText();
            String newGenre = movieGenreField.getText();
            int newSeats;
            try {
                newSeats = Integer.parseInt(movieSeatsField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number of seats.");
                return;
            }

            selectedMovie.setTitle(newTitle);
            selectedMovie.setDirector(newDirector);
            selectedMovie.setGenre(newGenre);
            selectedMovie.setSeats(newSeats);

            movieListView.refresh();
            System.out.println("Updated movie: " + selectedMovie.getTitle());

            clearMovieFields();
        } else {
            System.out.println("No movie selected for update.");
        }
    }

    @FXML
    private void onAddMovieButtonClicked(ActionEvent event) {
        String title = movieTitleField.getText();
        String director = movieDirectorField.getText();
        String genre = movieGenreField.getText();
        int seats;
        try {
            seats = Integer.parseInt(movieSeatsField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number of seats.");
            return;
        }

        Movie newMovie = new Movie(title, director, genre, seats);
        MovieManager.getInstance().addMovie(newMovie);
        movieListView.refresh();
        System.out.println("Added new movie: " + title);

        clearMovieFields();
    }

    @FXML
    private void onExitButtonClicked(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onGoBackToLoginButtonClicked(ActionEvent event) {
        try {
            Main.loadView("logInMenu-view.fxml", 400, 600);  // Provide necessary width and height
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to go back to login view.");
        }
    }

    private void clearMovieFields() {
        movieTitleField.clear();
        movieDirectorField.clear();
        movieGenreField.clear();
        movieSeatsField.clear();
    }
}
