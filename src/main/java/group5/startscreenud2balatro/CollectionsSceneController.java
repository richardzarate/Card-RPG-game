package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CollectionsSceneController {
    @FXML
    private Button exitCollectionsButton;
    @FXML
    private TextArea collections;


    @FXML
    private void onClickExit() {
        System.out.println("Exiting Collections...");

        Stage stage = (Stage) exitCollectionsButton.getScene().getWindow();  // closes the GUI if the exit button is clicked
        stage.close();

        // change to link back to start screen if time permits
    }
}
