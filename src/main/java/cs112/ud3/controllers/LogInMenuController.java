package cs112.ud3.controllers;

import cs112.ud3.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.stage.Stage;

public class LogInMenuController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button regularLoginButton;

    @FXML
    private Button showMoviesButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label feedbackLabel;

    @FXML
    private void onAdminLoginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateAdminCredentials(username, password)) {
            try {
                Main.loadView("adminUser-view.fxml", 600, 800);
            } catch (IOException e) {
                feedbackLabel.setText("Failed to load admin view.");
                e.printStackTrace();
            }
        } else {
            feedbackLabel.setText("Invalid admin credentials.");
        }
    }

    @FXML
    private void onRegularLoginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateRegularUserCredentials(username, password)) {
            try {
                Main.loadView("regularUser-view.fxml", 400, 600);
            } catch (IOException e) {
                feedbackLabel.setText("Failed to load regular user view.");
                e.printStackTrace();
            }
        } else {
            feedbackLabel.setText("Invalid regular user credentials.");
        }
    }

    @FXML
    private void onShowMoviesButtonClicked(ActionEvent event) {
        try {
            Main.loadView("showMovies-view.fxml", 600, 800);  // Ensure the correct path
        } catch (IOException e) {
            feedbackLabel.setText("Failed to load show movies view.");
            e.printStackTrace();
        }
    }

    @FXML
    private void onExitButtonClicked(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private boolean validateAdminCredentials(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }

    private boolean validateRegularUserCredentials(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }
}
