package cs112.ud3.controllers;
import cs112.ud3.models.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class UpdateMovieDetailsController {
    @FXML
    private Button updateMovieButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button goBackToLoginButton;
    @FXML
    private TextField updateMovieTitleField;
    @FXML
    private TextField updateMovieDirectorField;
    @FXML
    private TextField updateMovieGenreField;
    @FXML
    private TextField updateMovieSeatsField;
    @FXML
    private ListView<Movie> movieListView;
    private ObservableList<Movie> movieList;
    // Initialize method to set up any necessary data or event handlers
    @FXML
    private void initialize() {
        movieList = FXCollections.observableArrayList();
        movieListView.setItems(movieList);
        // Sample data for testing
        movieList.add(new Movie("Sample Movie", "Director Name", "Genre", 50));
    }
    // Event handler for Update Movie Details button
    @FXML
    private void onUpdateMovieButtonClicked(ActionEvent event) {
        Movie selectedMovie = movieListView.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            String newTitle = updateMovieTitleField.getText();
            String newDirector = updateMovieDirectorField.getText();
            String newGenre = updateMovieGenreField.getText();
            int newSeats;
            try {
                newSeats = Integer.parseInt(updateMovieSeatsField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number of seats.");
                return;
            }
            selectedMovie.updateMovieDetails(newTitle, newDirector, newGenre, newSeats);
            movieListView.refresh();
            System.out.println("Updated movie: " + selectedMovie.getTitle());
            clearUpdateMovieFields();
        } else {
            System.out.println("No movie selected for update.");
        }
    }
    // Event handler for Exit button
    @FXML
    private void onExitButtonClicked(ActionEvent event) {
        System.out.println("Exit button clicked");
        // Add your logic to quit the application or close the current window
    }
    // Event handler for Go Back To Login button
    @FXML
    private void onGoBackToLoginButtonClicked(ActionEvent event) {
        System.out.println("Go Back To Login button clicked");
        // Add your logic to navigate back to the login view or perform other actions
    }
    // Helper methods to clear fields
    private void clearUpdateMovieFields() {
        updateMovieTitleField.clear();
        updateMovieDirectorField.clear();
        updateMovieGenreField.clear();
        updateMovieSeatsField.clear();
    }
}
