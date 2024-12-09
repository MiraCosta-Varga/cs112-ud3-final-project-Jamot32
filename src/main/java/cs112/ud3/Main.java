package cs112.ud3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        loadView("logInMenu-view.fxml");  // Load the initial login view
        primaryStage.setTitle("Login Menu");
        primaryStage.show();
    }

    public static void loadView(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
