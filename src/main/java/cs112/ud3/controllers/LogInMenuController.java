package cs112.ud3.controllers;

import cs112.ud3.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

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
    private Label feedbackLabel;

    @FXML
    private void onAdminLoginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate admin credentials
        if (validateAdminCredentials(username, password)) {
            try {
                Main.loadView("adminUser-view.fxml");
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

        // Validate regular user credentials
        if (validateRegularUserCredentials(username, password)) {
            try {
                Main.loadView("regularUser-view.fxml");
            } catch (IOException e) {
                feedbackLabel.setText("Failed to load regular user view.");
                e.printStackTrace();
            }
        } else {
            feedbackLabel.setText("Invalid regular user credentials.");
        }
    }

    // Stub methods for credentials validation - implement your actual validation logic
    private boolean validateAdminCredentials(String username, String password) {
        // Example validation logic
        return "admin".equals(username) && "password".equals(password);
    }

    private boolean validateRegularUserCredentials(String username, String password) {
        // Example validation logic
        return "user".equals(username) && "password".equals(password);
    }
}
