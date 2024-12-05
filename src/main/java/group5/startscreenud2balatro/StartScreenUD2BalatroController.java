package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StartScreenUD2BalatroController {
    // Image view
    @FXML
    private ImageView imageView;

    @FXML
    private Button P1;

    @FXML
    private Button playButton;

    @FXML
    private Button optionsButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button collectionButton;

    // method to load the image
    public void initialize() {
        // Load the image
        Image image = new Image(getClass().getResource("/group5/StartScreenBalatro.png").toExternalForm());
        imageView.setImage(image);
    }

    @FXML
    private void onClickProfile() {
        System.out.println("Profile button clicked!");
        // Add actions here
        // User starts

    }

    @FXML
    private void onClickPlay() {
        System.out.println("Play button clicked!");

        // Add actions here
        // Starts a new game
    }

    @FXML
    private void onClickOptions() {
        System.out.println("Options button clicked!");

        // Add actions here
        // display user options including help screen
    }

    @FXML
    private void onClickQuit() {
        System.out.println("Quit button clicked!");
        Stage stage = (Stage) quitButton.getScene().getWindow();  // closes the GUI if the quit button is clicked
        stage.close();
    }

    @FXML
    private void onClickCollection() {
        System.out.println("Collection button clicked!");
        // Add collection-related functionality here
    }
}
