package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePlayController {

    @FXML
    private TextArea activityLogTextField;
    @FXML
    private TextArea playerInput;
    @FXML
    private TextArea attackType1;
    @FXML
    private TextArea attackType2;
    @FXML
    private TextArea attackType3;
    @FXML
    private TextArea attackType4;
    @FXML
    private TextArea attackType5;
    @FXML
    private TextArea playCharacterType1;
    @FXML
    private TextArea playCharacterType2;
    @FXML
    private TextArea playCharacterType3;
    @FXML
    private TextArea playingCharacterType1;
    @FXML
    private TextArea playingCharacterType2;
    @FXML
    private TextArea playingCharacterType3;
    @FXML
    private Label activityLogLabel;
    @FXML
    private Label floor;
    @FXML
    private Label options;
    @FXML
    private Label playInput;
    @FXML
    private Button homeButton;
    @FXML
    private void onClickHome() {
        System.out.println("Home button clicked!");
        // Load the StartScreen scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/StartScreenUD2Balatro.fxml"));
            Parent startScreenRoot = fxmlLoader.load();
            Scene startScreenScene = new Scene(startScreenRoot);

            // Get the current stage and set the StartScreen scene
            Stage stage = (Stage) homeButton.getScene().getWindow();  // Corrected reference to 'home' button
            stage.setScene(startScreenScene);
        } catch (IOException e) {
            System.err.println("Error loading StartScreen: " + e.getMessage());
        }
    }

    public void logPlayerInput() {
        // Get the current input from the playerInput TextArea
        String playerInputText = playerInput.getText();

    }

    // add more methods to handle attack types or charac

}