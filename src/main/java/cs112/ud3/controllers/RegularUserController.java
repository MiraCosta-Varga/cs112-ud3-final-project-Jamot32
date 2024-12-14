package cs112.ud3.controllers;

import cs112.ud3.models.Movie;
import cs112.ud3.models.MovieNotAvailableException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;

public class RegularUserController {

    @FXML
    private ListView<Movie> movieListView;

    @FXML
    private TextField seatsTextField;

    @FXML
    private Button bookButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Label feedbackLabel;

    private ObservableList<Movie> movieList;

    @FXML
    private void initialize() {
        movieListView.setItems(movieList);
    }

    @FXML
    private void onBookButtonClicked(ActionEvent event) {
        Movie selectedMovie = movieListView.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            try {
                int seats = Integer.parseInt(seatsTextField.getText());
                    feedbackLabel.setText("Successfully booked " + seats + " tickets for movie: " + selectedMovie.getTitle());
            } catch (NumberFormatException e) {
                feedbackLabel.setText("Please enter a valid number of seats.");
            } catch (MovieNotAvailableException e) {
                feedbackLabel.setText(e.getMessage());
            }
        } else {
            feedbackLabel.setText("No movie selected for booking.");
        }
    }

    @FXML
    private void onCancelButtonClicked(ActionEvent event) {
        Movie selectedMovie = movieListView.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            try {
                int seats = Integer.parseInt(seatsTextField.getText());
                feedbackLabel.setText("Successfully canceled " + seats + " tickets for movie: " + selectedMovie.getTitle());
            } catch (NumberFormatException e) {
                feedbackLabel.setText("Please enter a valid number of seats.");
            }
        } else {
            feedbackLabel.setText("No movie selected for cancellation.");
        }
    }

    @FXML
    private void onLogoutButtonClicked(ActionEvent event) {
        System.out.println("Logout button clicked");
    }
}
