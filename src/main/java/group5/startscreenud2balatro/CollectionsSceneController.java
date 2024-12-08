package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class CollectionsSceneController {
    @FXML
    private Button exitCollectionsButton;
    @FXML
    private TextArea collections;


    @FXML
    private void onClickExit() {
        System.out.println("Exiting Collections...");
// Load the StartScreen scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/StartScreenUD2Balatro.fxml"));
            Parent startScreenRoot = fxmlLoader.load();
            Scene startScreenScene = new Scene(startScreenRoot);

            // Get the current stage and set the StartScreen scene
            Stage stage = (Stage) exitCollectionsButton.getScene().getWindow();
            stage.setScene(startScreenScene);
        } catch (IOException e) {
            System.err.println("Error loading StartScreen: " + e.getMessage());
        }
    }
}
