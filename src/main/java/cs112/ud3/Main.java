package cs112.ud3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        loadView("logInMenu-view.fxml", 400, 600);  // Load the initial login view
        primaryStage.setTitle("Login Menu");
        primaryStage.setMinWidth(300);  // Minimum width to ensure the layout fits well
        primaryStage.setMinHeight(400); // Minimum height to ensure the layout fits well
        primaryStage.show();
    }

    public static void loadView(String fxml, int width, int height) throws IOException {
        System.out.println("Loading view: " + fxml);
        URL fxmlLocation = Main.class.getResource("/cs112/ud3/" + fxml);
        if (fxmlLocation == null) {
            System.err.println("FXML file not found: " + fxml);
            throw new IOException("FXML file not found: " + fxml);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
