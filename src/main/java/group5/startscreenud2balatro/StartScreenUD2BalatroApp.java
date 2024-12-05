package group5.startscreenud2balatro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenUD2BalatroApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(StartScreenUD2BalatroApp.class.getResource("/group5/StartScreenUD2Balatro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Start Screen UD2 Balatro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}