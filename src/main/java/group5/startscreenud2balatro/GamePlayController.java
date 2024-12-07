package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class GamePlayController {

    @FXML
    private TextField gamePlayTextField;
    @FXML
    private ProgressBar PlayerProgressBar;
    @FXML
    private ProgressBar enemyProgressBar;
    @FXML
    private Text player;
    @FXML
    private Text enemy;


    /**
     * Updates the game state and modifies the label accordingly.
     * @param state The state of the game ("Playing", "Win", "Lose").
     */
    public void setGameState(String state) {
        switch (state) {
            case "Win":
                gamePlayTextField.setText("You Win!");
                break;
            case "Lose":
                gamePlayTextField.setText("Game Over");
                break;
            default:
                gamePlayTextField.setText("Playing...");
        }
    }

}