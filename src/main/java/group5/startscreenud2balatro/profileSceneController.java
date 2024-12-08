package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class profileSceneController {

    @FXML
    private Button saveButton;
    @FXML
    private Label playerName;
    @FXML
    private Label floor;

    @FXML
    private void onClickSave() {
        System.out.println("Saving Game...");

        // Load the StartScreen scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/StartScreenUD2Balatro.fxml"));
            Parent startScreenRoot = fxmlLoader.load();
            Scene startScreenScene = new Scene(startScreenRoot);

            // Get the current stage and set the StartScreen scene
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.setScene(startScreenScene);
        } catch (IOException e) {
            System.err.println("Error loading StartScreen: " + e.getMessage());
        }
    }
}
