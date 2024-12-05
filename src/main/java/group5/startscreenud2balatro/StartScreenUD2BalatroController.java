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
        // probably just going to screen shot and have the image change but if possible / time allows
        // Change to Profile screen with Text player1
        // progress bar?
        // Collections
        // Jocker Stickers
        // Deck stack Wins

    }

    @FXML
    private void onClickPlay() {
        System.out.println("Play button clicked!");

        // Generic Balatro Game play image?
    }

    @FXML
    private void onClickOptions() {
        System.out.println("Options button clicked!");

        // Image of Balatro's options screen

    }

    @FXML
    private void onClickQuit() {
        System.out.println("Quit button clicked!");
        Stage stage = (Stage) quitButton.getScene().getWindow();  // closes the GUI if the quit button is clicked
        stage.close();

        // Exit the Game possible image change exiting
    }

    @FXML
    private void onClickCollection() {
        System.out.println("Collection button clicked!");

        // Display Collections Image showing list of all gameplay items



     // If play looses gui changes to game over image
        // play again or exit button
     // If the play wins gui changes to You win screen
        // play again or exit button

    }
}
