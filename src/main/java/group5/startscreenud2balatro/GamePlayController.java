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
    private TextField activityLogTextField;
    @FXML
    private TextField playerInput;
    @FXML
    private TextField attackType1;
    @FXML
    private TextField attackType2;
    @FXML
    private TextField attackType3;
    @FXML
    private TextField attackType4;
    @FXML
    private TextField attackType5;
    private TextField playCharacterType1;
    @FXML
    private TextField playCharacterType2;
    @FXML
    private TextField playCharacterType3;
    private TextField playingCharacterType1;
    @FXML
    private TextField playingCharacterType2;
    @FXML
    private TextField playingCharacterType3;

    /**
     * Updates the game state and modifies the label accordingly.
     * @param state The state of the game ("Playing", "Win", "Lose").
     */
   /* public void setGameState(String state) {
        switch (state) {
            case "Win":
                activityLogTextField.setText("You Win!");
                break;
            case "Lose":
                activityLogTextField.setText("Game Over");
                break;
            default:
                activityLogTextField.setText("Playing...");
        }
    }
*/


}