package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



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

        Stage stage = (Stage) saveButton.getScene().getWindow();  // closes the GUI if the save button is clicked, can be updated to read to file
        stage.close();
    }
}
