package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GamePlayController {

    @FXML
    private Label gameStatusLabel;

    @FXML
    private ImageView gamePlayImage;

   /* public void initialize() {
        // Load the image when the scene is initialized
        Image image = new Image(getClass().getResource("/group5/gamePlayScreen.png").toExternalForm());
        gamePlayImage.setImage(image);
    }
    */
    /**
     * Updates the game state and modifies the label accordingly.
     * @param state The state of the game ("Playing", "Win", "Lose").
     */
    public void setGameState(String state) {
        switch (state) {
            case "Win":
                gameStatusLabel.setText("You Win!");
                break;
            case "Lose":
                gameStatusLabel.setText("Game Over");
                break;
            default:
                gameStatusLabel.setText("Playing...");
        }
    }
}