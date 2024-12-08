package group5.startscreenud2balatro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

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
    private void onClickProfile(ActionEvent e) throws IOException {
        System.out.println("Profile Button Clicked!");
        // Load profile scene
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/group5/profileScreen.fxml"));
            Parent profileRoot =  fxmlLoader2.load();
            Scene profileScene = new Scene(profileRoot);
            Stage stage = (Stage) P1.getScene().getWindow();
            stage.setScene(profileScene);
    }
    @FXML
    private void onClickPlay(ActionEvent event) throws IOException {
        System.out.println("Play button clicked!");
        // Load GamePlay scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/GameScreen.fxml"));
        Parent gamePlayRoot = fxmlLoader.load();
        Scene gamePlayScene = new Scene(gamePlayRoot);
        Stage stage = (Stage) playButton.getScene().getWindow();
        stage.setScene(gamePlayScene);
    }

    @FXML
    private void onClickOptions() {
        System.out.println("Options button clicked!");

        // Image of Balatro's options screen
        // stage.setScene() method to change to Options scene

    }

    @FXML
    private void onClickQuit() {
        System.out.println("Quit button clicked!");

        Stage stage = (Stage) quitButton.getScene().getWindow();  // closes the GUI if the quit button is clicked
        stage.close();

        // Exit the Game possible image change exiting
        // stage.setScene() method to change to exit scene
    }

    @FXML
    private void onClickCollection() {
        System.out.println("Collection button clicked!");

        // Display Collections Image showing list of all gameplay items
        // stage.setScene() method to change to collection



     // If play looses gui changes to game over image
        // play again or exit button
        //stage.setScene() method to change
     // If the play wins gui changes to You win screen
        // play again or exit button
        //stage.setScene() method to change

    }
}
